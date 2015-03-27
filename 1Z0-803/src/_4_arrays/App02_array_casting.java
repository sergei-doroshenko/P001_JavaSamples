package _4_arrays;

/**
 * Created by Sergei Doroshenko on 27.03.2015.
 *
 * - The program will throw a java.lang.ClassCastException at the line labelled 3 when run.
 * - The cast at line 2 is needed.
 *
 */
public class App02_array_casting {
    public static void main(String[] args) {
        A[] a, a1;
        B[] b;
        a = new A[10];
        a1 = a;
        b = new B[20];
        a = b; // 1, now a reference to B[] (array of B)
        b = (B[]) a; // 2, so we could cast 'a' ref to B[], because 'a' -> B[], without runtime error
        b = (B[]) a1; // 3, ClassCastException, because 'a1' -> A[]
    }
}

class A { }
class B extends A { }