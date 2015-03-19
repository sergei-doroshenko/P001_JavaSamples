package _7_inheritance._1_class_cast;

/**
 * Created by Sergei on 19.03.2015.
 */
public class App00 {

    public static void main(String[] args) {
        A[] a, a1;
        B[] b;
        a = new A[10];
        a1 = a;
        b = new B[20];
        a = b; // 1
        b = (B[]) a;  // 2
        b = (B[]) a1; // 3 ClassCastException
    }

}

class A { }
class B extends A { }
