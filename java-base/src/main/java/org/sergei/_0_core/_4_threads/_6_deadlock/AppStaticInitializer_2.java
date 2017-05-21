package org.sergei._0_core._4_threads._6_deadlock;

/**
 * Created by Sergei on 10.04.2015.
 */
public class AppStaticInitializer_2 {

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        System.out.println("1");
        new Thread(new Runnable() {
            @Override
            public void run() {
                ParentA p = ParentA.EMPTY;
            }
        }).start();

        Thread.sleep(1);

        Class.forName("Child");
//        new Child();
        System.out.println("2");
    }
}

abstract class ParentA {
    public static final ParentA EMPTY  = new Child();
//    static {EMPTY = new Child(); }

    /*public ParentA() {
        System.out.println("P");
    }*/
}

class Child extends ParentA {
    /*public Child() {
        System.out.println("C");
    }*/
}
