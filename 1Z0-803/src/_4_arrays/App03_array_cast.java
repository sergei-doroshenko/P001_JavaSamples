package _4_arrays;

/**
 * Created by Sergei on 27.03.2015.
 */
public class App03_array_cast {
    public static void main(String[] args) {
        A1[] a = new A1[10];
        B1[] b = new B1[10];

        /* So could persuade the compiler to threat
         * the array referenced by 'a' (which is array of A1-objects)
         * like array of B1-objects.
         * But in runtime JVM will find out that it is lie.
         * And ClassCastException will be thrown. */
        B1[] x = (B1[]) a;

        /* The same situation */

        String[] aS = new String[3];
        Integer[] aI = new Integer[3];
        Object[] aO = aI;
        aS = (String[]) aO;
        aS = (String[]) (Object[]) aI;

    }
}

class A1 {}
class B1 extends A1 {}
