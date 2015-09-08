package _3_operators_if_else;

/**
 * Created by Sergei on 30.03.2015.
 */
public class App05 {
    public static void main(String[] args) {
        /*
        getA(false) prints: A
        getA(true) prints: ABC
         */
        boolean b0 = getA(false) && getB() && getC();
        System.out.println();
        /*
        getA(false) prints AB
        getA(true) prints A
         */
        boolean b1 = getA(true) || getB() || getC();
    }

    private static boolean getA(boolean b) {
        System.out.print("A");
        return b;
    }

    private static boolean getB() {
        System.out.print("B");
        return true;
    }

    private static boolean getC() {
        System.out.print("C");
        return true;
    }
}
