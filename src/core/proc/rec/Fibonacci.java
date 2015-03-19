package core.proc.rec;

/**
 * Created by Sergei on 22.02.2015.
 */
public class Fibonacci {
    public static void main (String[] args) {

        System.out.println(fib(5));
        System.out.println(fibRec(5));
    }

    public static int fib (int k) {
        int result;

        if (k == 0 || k == 1) {
            result = 1;
        } else {
            int temp0 = fib(k - 2);
            System.out.print(k + " ");
            int temp1 = fib(k - 1);
            result = temp0 + temp1;
        }


        return result;
    }

    public static int fibRec(int k) {
        return k < 2 ? 1 : fibRec(k - 2) + fibRec(k - 1);
    }
    /* result 4572 and java.lang.StackOverflowError */
}
