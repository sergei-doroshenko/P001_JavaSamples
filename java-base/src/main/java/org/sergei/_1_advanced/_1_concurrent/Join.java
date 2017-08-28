package org.sergei._1_advanced._1_concurrent;

/**
 * Created by sergei on 12/28/15.
 */
public class Join {
    // volatile doesn't save the situation
    // with shared data
    public static volatile long i = 0;
    public static int iterations = 10000;

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread() {
            @Override
            public void run() {
//                super.run();
                for (int j = 0; j < iterations; j++) {
                    i++;
                }

            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int j = 0; j < iterations; j++) {
                    i++;
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i); // the output may be - 14770
    }

}
