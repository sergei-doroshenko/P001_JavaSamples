package core._0_proc._0_folklore;

/**
 * Created by Sergei on 22.03.2015.
 */
public class App00Swap {
    public static void main(String[] args) {
        int a = 3;
        int b = 15;
       /*
        a = b - a; // 2
        b = b - a; // 5
        a = a + b; // 7
        */

        /*a = (a = b-a) + (b = b-a);*/

       /* a = (a -= b) + (b -= a);*/

        a = a + b; // 10
        b = a - b; // 3 a - b = (-b + a) = -(b - a) = -(b =- a)
        a = a - b; // 7

        System.out.println("a = " + a + ", b = " + b);

        int x = 3;
        int y = 7;

       /*
        x = x ^ y;
        y = y ^ x;
        x = x ^ y;
        */

        /*x = (x = x^y) ^ (y = y^x);*/

        x = (x ^= y) ^ (y ^= x);

        System.out.println("x = " + x + ", y = " + y);
    }
}
