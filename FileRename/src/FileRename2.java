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

        final Path src = Paths.get("/home/sergei/Downloads/music");
        final String pattern = "_(zv.fm)";

        /*final Path src = Paths.get(args[0]);
        final String pattern = args[1];*/

//        rename1(src, pattern);
        rename2(src, pattern);
    }

    private static void rename1(final Path src, final String pattern) throws IOException {
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
        });
    }

    private static void rename2(final Path src, final String pattern) {
        try {
            Files.walkFileTree(src, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {

                    String name = path.getFileName().toString();

                    if (name.indexOf(pattern) > 0 ) {
                        /*String newName = name.substring(0, name.indexOf(pattern))
                                + name.substring(name.indexOf(pattern) + pattern.length());*/
                        String newName = name.replace(pattern, "");
                        Path newD = src.resolve(newName);

                        System.out.println("file: " + path + " renamed to: " + newD + "\n");

                        Files.move(path, newD, StandardCopyOption.REPLACE_EXISTING);
                    }

                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final static String helpMessage = "Usage: java FileRename2 <source-path> <file-name-pattern>";
    /*
    /home/sergei/photos/src file-2015-
     */
}
