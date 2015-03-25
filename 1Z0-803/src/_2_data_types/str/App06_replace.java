package _2_data_types.str;

/**
 * Created by Sergei on 25.03.2015.
 */
public class App06_replace {
    public static void main(String[] args) {
        String string = "abcde";
        StringBuilder sb = new StringBuilder(string);

        string = string.replace("bc", "123");
        System.out.println(string); // a123de

        sb.replace(1, 3, "123");
        System.out.println(sb); // a123de

        sb.delete(1, 4);
        System.out.println(sb); // ade

        sb.insert(1, "123", 1, 2);
        System.out.println(sb); // a2de

        sb.reverse();
        System.out.println(sb); // ed2a
    }
}
