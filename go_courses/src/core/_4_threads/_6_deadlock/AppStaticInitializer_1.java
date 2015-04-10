package core._4_threads._6_deadlock;

/**
 * Created by Sergei on 10.04.2015.
 */
public class AppStaticInitializer_1 {
    static class A {
        static final B b;
        static {
            System.out.println("start A's static initialization block");
            b =  new B();
            System.out.println("end A's static initialization block");
        }
    }

    static class B {
        static final A a;
        static {
            System.out.println("start B's static initialization block");
            a = new A();
            System.out.println("end B's static initialization block");
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new A();
            }
        }).start();

        new B();
    }
}
