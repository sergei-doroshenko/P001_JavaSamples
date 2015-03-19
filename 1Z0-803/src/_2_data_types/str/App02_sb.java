package _2_data_types.str;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App02_sb {
    public static void main(String[] args) {
        StringBuilder sb0 = new StringBuilder("abcd");
        System.out.println(sb0); // abcd
        sb0.deleteCharAt(2);
        System.out.println(sb0); // abd
        sb0.setCharAt(0, 'A');
        System.out.println(sb0); // Abd
        System.out.println(sb0.length()); // 3
        System.out.println(sb0.capacity()); // 20
        sb0.trimToSize();
        System.out.println(sb0.capacity()); // 3

    }

}
