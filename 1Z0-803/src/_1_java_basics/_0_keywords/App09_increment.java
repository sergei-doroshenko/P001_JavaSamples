package _1_java_basics._0_keywords;

/**
 * Created by Sergei on 13.07.2015.
 */
public class App09_increment {
    public static void main(String[] args) {
        int a = 10;
        int b = 7;
        int c = ++a - --b + a-- - ++b + b;
        // 11 - 6 + 10 - 7 + 7 = 16
        System.out.println("c: " + c + ", a: " + a + ", b: " + b);

        int x = 10;
        int y = ++x + x--; // y = 11 + 11 = 22, x = 10;
        System.out.println("x: " + x + ", y: " + y);

    }
}
