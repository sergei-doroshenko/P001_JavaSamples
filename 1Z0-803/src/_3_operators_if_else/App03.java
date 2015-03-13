package _3_operators_if_else;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App03 {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        if ( (a = 3) > 2 || (b = 4) < 3 ) System.out.println("a=" + a + " b=" + b); // a=3 b=0

        a = 0; b = 0;
        if ( (a = 3) > 2 | (b = 4) < 3 ) System.out.println("a=" + a + " b=" + b);  // a=3 b=4

        a = 0; b = 0;
        if ( (a = 3) < 2 && (b = 4) > 3 );
        System.out.println("a=" + a + " b=" + b);  // a=3 b=0

        a = 0; b = 0;
        if ( (a = 3) < 2 & (b = 4) > 3 );
        System.out.println("a=" + a + " b=" + b);  // a=3 b=4

        int j = 2;
        boolean b0 = j++ == 2; // true
        System.out.println("b0 = " + b0 + ", j = " + j);
    }
}
