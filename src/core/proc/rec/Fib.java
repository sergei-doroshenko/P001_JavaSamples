package core.proc.rec;

/**
 * Created by Sergei on 22.02.2015.
 */
public class Fib {
    public static void main (String[] args) {
        System.out.println(fib(5));
    }

    public static int fib (int k) {
        System.out.println(k);
        if (k == 0) return 1;
        if (k == 1) return 1;
        return fib(k - 1) + fib(k - 2);


    }
    /* result 4572 and java.lang.StackOverflowError */
}
