package org.sergei._0_core._4_threads._5_juc._5_atomic;

//import net.jcip.examples.ConcurrentStack;


/**
 * Created by Sergei on 10.04.2015.
 */
public class TreiberStackApp {
    public static void main(String[] args) throws InterruptedException {
        /*final ConcurrentStack<Integer> stack = new ConcurrentStack();

        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ThreadUtils.sleep(new Random().nextInt(10) * 7);
                    stack.push(i);
                }

            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    ThreadUtils.sleep(new Random().nextInt(10) * 7);
                    stack.push(i);
                }
            }
        });

        t0.start();
        t1.start();

        t0.join();
        t1.join();

        System.out.println(stack);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ThreadUtils.sleep(new Random().nextInt(10) * 7);
                    System.out.print("-" + stack.pop() + " ");
                }

            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    ThreadUtils.sleep(new Random().nextInt(10) * 7);
                    System.out.print("=" + stack.pop() + " ");
                }
            }
        });

        t2.start();
        t3.start();*/


    }
}
