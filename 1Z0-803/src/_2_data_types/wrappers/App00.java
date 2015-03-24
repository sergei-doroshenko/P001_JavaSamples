package _2_data_types.wrappers;

/**
 * Created by Sergei on 24.03.2015.
 */
public class App00 {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 7;
        System.out.println(a + b); // 10
        System.out.println(new Integer(6) + new Integer(7)); // 13
    }
}
