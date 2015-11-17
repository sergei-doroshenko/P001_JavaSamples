import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Sergei Doroshenko on 02.10.2015.
 * Implementation for java 1.7
 */
public class FileRename2 {
    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
            System.out.println(helpMessage);
            System.exit(1);
        }

        /*final Path src = Paths.get("/home/sergei/photos/src");
        final String pattern = "file-123-";*/

        final Path src = Paths.get(args[0]);
        final String pattern = args[1];

        Files.walkFileTree(src, new SimpleFileVisitor<Path>() {
            private int count = 0;

            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {

                String name = path.getFileName().toString();
                String ext = name.substring(name.lastIndexOf('.'));
                String newName = pattern + (count < 10 ? "0" + count++ : count++) + ext;
                Path newD = src.resolve(newName);

                System.out.println("file: " + path + " renamed to: " + newD + "\n");

                try {
                    Files.move(path, newD, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return FileVisitResult.CONTINUE;
            }
        })
    }

    private final static String helpMessage = "Usage: java FileRename2 <source-path> <file-name-pattern>";
    /*
    /home/sergei/photos/src file-2015-
     */
}
