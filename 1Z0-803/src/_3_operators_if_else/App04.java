package _3_operators_if_else;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App04 {
    static boolean a;
    static boolean b;
    static boolean c;

    public static void main (String[] args){

        boolean bool = (a = true) || (b = true) && (c = true);

        System.out.print(a + ", " + b + ", " + c);

        boolean b1 = false;
        boolean b2 = false;

        /* invalid */
        /*if (b2 != b1 = !b2){
            System.out.println("true");
        }*/

    }
}
