package core._3_io._0_charset;

import java.util.Arrays;

/**
 * Created by Sergei on 02.03.2015.
 */
public class App01 {
    public static void main(String[] args) {

        char[] chars = Character.toChars(150_000);
        System.out.println(chars);
        System.out.println(chars.length); // 2
        System.out.println((int) chars[0]); // 55378
        System.out.println((int) chars[1]); // 56816
        System.out.println(Arrays.toString(chars));

        // next step -> create two chars
        char ch1 = 55378;
        char ch2 = 56816;
        // then create string from char array
        String str = new String(new char[]{ch1, ch2});
        System.out.println(str); // prints 𤧰 there is 1 char, but length is 2
        System.out.println(str.length());
        System.out.println(str.codePointCount(0, 2));
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(1));
    }
}
