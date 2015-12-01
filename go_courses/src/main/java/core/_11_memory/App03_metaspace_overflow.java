package core._11_memory;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergei on 05.10.2015.
 * Execution of this code results in
 * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace.
 * immediately with JVM option -XX:MaxMetaspaceSize=8m.
 * And can load 852 simple classes with JVM option -XX:MaxMetaspaceSize=16m
 * and then throw the same exception.
 */
public class App03_metaspace_overflow {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<Class> list = new ArrayList<>();

        for(int i = 0; ;i++) {
            ClassLoader loader = new ClassLoader() {

                public static final String OUTPUT_DIR = "D:\\Projects\\IdeaProjects\\goCourses\\go_courses\\target\\classes\\core\\_11_memory";
                public static final String SOURCE_DIR = "D:\\Projects\\IdeaProjects\\goCourses\\go_courses\\src\\main\\java\\core\\_11_memory\\";

                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    if(!name.startsWith("Permgen"))
                        return super.loadClass(name);

                    try {
                        createClass(name);

                        String url = "file:D:\\Projects\\IdeaProjects\\goCourses\\go_courses\\target\\classes\\core\\_11_memory\\" + name + ".class";
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
                /*"package main.java.core._11_memory_overflow; \n" +*/
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
            };

            Class clazz = loader.loadClass("PermgenTest" + i);
            list.add(clazz);
            System.out.println(list.size());
        }
    }
}
