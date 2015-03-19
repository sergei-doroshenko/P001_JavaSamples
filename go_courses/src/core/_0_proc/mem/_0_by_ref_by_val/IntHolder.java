package core._0_proc.mem._0_by_ref_by_val;

/**
 * Created by Sergei on 25.02.2015.
 */
public class IntHolder {
    public int value;

    public IntHolder(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        IntHolder x = new IntHolder(0);

        f(x);
        System.out.println("x: " + x.value); // print 1

        g(x);
        System.out.println("x: " + x.value); // print 1

        x = k(x);
        System.out.println("x: " + x.value); // print 3
    }

    private static void f(IntHolder x) {
        x.value = 1;
        x = null;
    }

    private static void g(IntHolder x) {
        x = new IntHolder(2);
    }
    private static IntHolder k(IntHolder x) {
        x = new IntHolder(3);
        return x;
    }

}
