package _2_data_types.str;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App03_sb {
    public static void main(String[] args) {
        String s = "blooper";
        StringBuilder sb = new StringBuilder(s);
        sb.append(s.substring(4)).delete(3, 5); // "blooperper".delete(3, 5) => bloerper

        /*
        012 34 56799
        blo op erper
        blo    erper
        */

        System.out.println(sb); // bloerper
        /*hello.length() = 6*/
        System.out.println(new StringBuilder("world").insert(0, "hello ", 0, 6).toString()); // hello world
    }

}
