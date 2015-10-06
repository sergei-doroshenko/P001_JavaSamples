package core._11_memory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 05.10.2015.
 * Results in Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 * when run with -XX:MaxMetaspaceSize=8m JVM option and loaded 574 classes.
 */
public class App02_metaspace_overflow {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<Class> list = new ArrayList<>();

        for(;;) {
            ClassLoader loader = new ClassLoader() {

                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    if(!name.endsWith("PermgenTest"))
                        return super.loadClass(name);

                    try {
                        String url = "file:D:\\Projects\\IdeaProjects\\goCourses\\go_courses\\target\\classes\\core\\_11_memory\\PermgenTest.class";
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
            };

            Class clazz = loader.loadClass("core._11_memory.PermgenTest");
            list.add(clazz);
            System.out.println(list.size());
            System.out.println(clazz.getClassLoader());
        }
    }
}
