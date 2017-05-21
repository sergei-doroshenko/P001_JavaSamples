import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Sergei on 02.10.2015.
 */
public class FileListing {
    public static void main(String[] args) throws IOException {
        final String baseDir = "D:\\Photos\\Temp\\Test\\";
        final String nameTemplate = "my_func";
        final int[] idx = {0};

        Files.list(Paths.get(baseDir))
                .forEach(file -> {
                    Path target = FileSystems.getDefault().getPath(baseDir + nameTemplate + "_" + (idx[0]++) + ".jpg");

                    try {
                        Files.move(file, target);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(file.getFileName());
                } );


        Files.walk(Paths.get("D:\\Photos\\Temp\\Test"))
                .forEach(filePath -> {
                    Path target = FileSystems.getDefault().getPath("D:\\Photos\\Temp\\Test" + (idx[0]++) + ".jpg");
                    System.out.println(filePath);
                    /*try {
                        Files.move(filePath, target);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                });
    }
}
