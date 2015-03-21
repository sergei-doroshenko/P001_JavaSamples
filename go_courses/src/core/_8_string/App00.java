package core._8_string;

/**
 * Created by Sergei on 20.03.2015.
 */
public class App00 {
    public static void main(String[] args) {
        String s0 = "hello";
        String s1 = s0.substring(1, 5);
        System.out.println(s0);
        System.out.println(s1);

        char[] chars = s0.toCharArray();
        chars[1] = 'B';
        String s3 = new String(chars, 1, 4);
        System.out.println(s3);

        String s4 = new String(new int[]{165_000}, 0, 1);
        System.out.println(s4); // 𨒈
        System.out.println(s4.length()); // 2
        System.out.println(s4.codePointCount(0, s4.length())); // 1

    }
}
