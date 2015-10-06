package core._11_memory_overflow;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

/**
 * Created by Sergei on 05.10.2015.
 */
public class App02_pergen_overflow {

    public static void main(String[] args) {
        ClassLoader loader = new MyClassLoader(MyClassLoader.class.getClassLoader());

            try {
                for(int i = 0;;i++) {

                    Class clazz = loader.loadClass("PermgenTest" + i);
                    System.out.println(clazz.newInstance().toString());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


    }


}

class MyClassLoader extends ClassLoader {

    public static final String OUTPUT_DIR = "D:\\IdeaProjects\\GoCourses\\out\\production\\go_courses\\core\\_11_memory_overflow";
    public static final String SOURCE_DIR = "D:\\IdeaProjects\\GoCourses\\go_courses\\src\\core\\_11_memory_overflow\\";

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(!name.startsWith("Permgen"))
            return super.loadClass(name);

        try {
            createClass(name);

            String url = "file:D:\\IdeaProjects\\GoCourses\\out\\production\\go_courses\\core\\_11_memory_overflow\\" + name + ".class";
            URL myUrl = new URL(url);
            URLConnection connection = myUrl.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();

            while(data != -1){
                buffer.write(data);
                data = input.read();
            }

            input.close();

            byte[] classData = buffer.toByteArray();

            return defineClass(name, classData, 0, classData.length);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void createClass(final String name) throws IOException {
        // create the source
        File sourceFile   = new File(SOURCE_DIR + name + ".java");
        FileWriter writer = new FileWriter(sourceFile);

        writer.write(
                /*"package core._11_memory_overflow; \n" +*/
                "public class " + name + " { \n" +
                        " public void doit() { \n" +
                        "   System.out.println(\"Hello world\") ;\n" +
                        " }\n" +
                        "}"
        );
        writer.close();

        JavaCompiler compiler  = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File(OUTPUT_DIR)));

        // Compile the file
        compiler.getTask(null,
                fileManager,
                null,
                null,
                null,
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile)))
                .call();

        fileManager.close();

        // delete the source file
        sourceFile.deleteOnExit();
    }
}
