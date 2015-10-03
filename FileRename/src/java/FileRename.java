import java.io.File;

/**
 * Created by Sergei on 01.08.2015.
 */
public class FileRename {
    public static final String BASE_DIR = "D:\\Photos\\Temp\\Photos";
    public static final String NAME_TEMPLATE = "Turkey_Moscow_2015";


    public static void main(String[] args) {
        File folder = new File(BASE_DIR);
        File[] files = folder.listFiles();


        for (int i = 0; i < files.length; i++) {
            File temp = files[i];
                temp.renameTo(new File(BASE_DIR + "\\" + composeNameRegex(temp.getName())));
//                temp.renameTo(new File(BASE_DIR + "\\" + NAME_TEMPLATE + "_" + (counter++) + "" + ".jpg"));
//                temp.renameTo(new File(BASE_DIR + "\\" + NAME_TEMPLATE + "_" + (i < 10 ? "0" + i : "" + i) + ".jpg"));

            System.out.println(temp.getName());
        }
        /*System.out.println(composeName("Turkey_Moscow_2015_09.jpg"));
        System.out.println(composeNameRegex("Turkey_Moscow_2015_09.jpg"));*/

    }

    public static String composeName(String name) {
        if (name.substring(name.lastIndexOf("_")+1, name.lastIndexOf(".")).length() < 3) {
            name = name.substring(0, name.lastIndexOf("_")+1) + "0" + name.substring(name.lastIndexOf("_")+1);
        }
        return name;
    }

    public static String composeNameRegex(String name) {
        return name.replaceFirst("(_)(\\d{1,2})(?=\\.)", "$1\\0$2");
    }
}
