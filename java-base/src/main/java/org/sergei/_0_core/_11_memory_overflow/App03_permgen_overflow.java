package org.sergei._0_core._11_memory_overflow;

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
 * When run with JVM option:
 * -XX:MaxMetaspaceSize=64m (or 32m)
 *
 * resulted in OutOfMemoryError
 * e.g. of output:
 * 9140 // number of objects
 * 9141
 * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 *
 */
public class App03_permgen_overflow {
    // /home/sergei/projects/idea_projects/goCourses/out/production/go_courses/_0_core/_11_memory_overflow/PermgenTest.class
    // java version
    //  public static final String OUTPUT_DIR = "D:\\IdeaProjects\\GoCourses\\out\\production\\go_courses\\_0_core\\_11_memory_overflow";
    //  public static final String SOURCE_DIR = "D:\\IdeaProjects\\GoCourses\\go_courses\\src\\_0_core\\_11_memory_overflow\\";

    public static final String OUTPUT_DIR = "E:\\projects\\idea_projects\\GoCourses\\out\\production\\go_courses\\_0_core\\_11_memory_overflow\\";
    public static final String SOURCE_DIR = "E:\\projects\\idea_projects\\GoCourses\\go_courses\\src\\main\\java\\_0_core\\_11_memory_overflow\\";

    // linux version
//    public static final String OUTPUT_DIR = "/home/sergei/projects/idea_projects/goCourses/out/production/go_courses/_0_core/_11_memory_overflow/";
//    public static final String SOURCE_DIR = "/home/sergei/projects/idea_projects/goCourses/go_courses/src/main/java/_0_core/_11_memory_overflow/";


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        List<Object> list = new ArrayList<>();

        for(;;) {
            ClassLoader loader = new ClassLoader() {

                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {

                    String className = name;

                    if(!className.startsWith("Permgen"))
                        return super.loadClass(name);

                    try {
                        createClass(className);

                        String url = "file:" + OUTPUT_DIR + name + ".class";
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
                    /*"package main.java._0_core._11_memory_overflow; \n" +*/
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

            Object object = loader.loadClass("PermgenTest").newInstance();

            list.add(object);
            System.out.println(list.size());
        }
    }
}
