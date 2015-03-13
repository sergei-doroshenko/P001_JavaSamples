package core.threads._8_juc._1_reentrant_lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Sergei on 19.02.2015.
 */
public class AppRL {
    public static void main (String[] args) {
        //final ConditionBoundedBuffer<String> buffer = new ConditionBoundedBuffer<String>(5);
        final BlockingQueue<String> buffer = new ArrayBlockingQueue<>(5, true);
        // Writer
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c = 'A'; c <= 'Z'; c++) {
                    try {
                        buffer.put("" + c);
                        System.out.println("->" + c);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
        //Reader
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    sleep(1000);
                    //try {
                        //String c = buffer.take();
                        String c = buffer.poll();
                        System.out.println("  <-" + c);
                    /*} catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            }
        }).start();
    }
    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
