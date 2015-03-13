package core.proc.rec;

/**
 * Created by Sergei on 22.02.2015.
 */
public class App00 {
    public static void main (String[] args) {
        f(1);
    }

    public static void f (int k) {
        System.out.print(" " + k);
        if (k < 17) {
            f(2 * k);
        }
        System.out.print(" " + k);
    }
}
