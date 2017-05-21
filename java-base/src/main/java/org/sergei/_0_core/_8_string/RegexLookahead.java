package org.sergei._0_core._8_string;

import java.util.regex.Pattern;

/**
 * Created by Sergei_Doroshenko on 1/21/2017.
 */
public class RegexLookahead {

    public static void main(String[] args) {
        positiveLookahead();
        System.out.println();
        negativeLookahead();
    }

    public static void positiveLookahead() {
        Pattern pattern = Pattern.compile("q(?!u)");
        System.out.println(pattern.matcher("qu").matches()); // false
        System.out.println(pattern.matcher("qz").matches()); // false
        System.out.println(pattern.matcher("qz").find()); // true

        pattern = Pattern.compile("q(?!u).*");
        System.out.println(pattern.matcher("qu").matches()); // false
        System.out.println(pattern.matcher("qz").matches()); // true
        System.out.println(pattern.matcher("qz").find()); // true
    }

    public static void negativeLookahead() {
        Pattern pattern = Pattern.compile("q(?=u)");
        System.out.println(pattern.matcher("qu").matches()); // false
        System.out.println(pattern.matcher("qz").matches()); // false
        System.out.println(pattern.matcher("qu").find()); // true

        pattern = Pattern.compile("q(?=u).*");
        System.out.println(pattern.matcher("qu").matches()); // true
        System.out.println(pattern.matcher("qz").matches()); // false
        System.out.println(pattern.matcher("qz").find()); // false
    }
}
