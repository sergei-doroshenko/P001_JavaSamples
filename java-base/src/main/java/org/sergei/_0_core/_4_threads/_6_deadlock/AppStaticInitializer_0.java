package org.sergei._0_core._4_threads._6_deadlock;

/**
 * Created by Sergei on 10.04.2015.
 */
public class AppStaticInitializer_0 {
    static class A {
        static final B b = new B();
    }

    static class B {
        static final A a = new A();
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
