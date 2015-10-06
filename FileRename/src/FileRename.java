import java.io.File;

/**
 * Created by Sergei on 01.08.2015.
 */
public class FileRename {
    public static final String BASE_DIR = "I:\\FotoPizzeriaGomel";
    public static final String NAME_TEMPLATE = "GomelPizzeria";


    public static void main(String[] args) {
        File file = new File(BASE_DIR);


        for (int i = 0; i < file.list().length; i++) {
            File temp = new File(BASE_DIR + "\\" + file.list()[i]);
            temp.renameTo(new File(BASE_DIR + "\\" + NAME_TEMPLATE + "_"
                    + (i < 10 ? "0" + i : "" + i) + ".jpg"));
            System.out.println(temp.getAbsolutePath());
        }
    }
}
