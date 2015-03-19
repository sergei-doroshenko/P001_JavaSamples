package _7_inheritance;

/**
 * Created by Sergei on 02.03.2015.
 */
public class App00 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        a = (B)(I) b;
        // a = (I) b; // An I is not an A. Therefore, it will not compile.
    }
}

interface I{
}
class A implements I{
}

class B extends A {
}

class C extends B{
}
