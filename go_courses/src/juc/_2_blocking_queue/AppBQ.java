package juc._2_blocking_queue;

import java.util.concurrent.*;

/**
 * Created by Sergei on 06.04.2015.
 */
public class AppBQ {
    public static void main(String[] args) {
//        final BlockingQueue<String> buffer = new ArrayBlockingQueue<>(5, true);
//        final BlockingQueue<String> buffer = new LinkedBlockingQueue<>(5);
//        final BlockingQueue<String> buffer = new LinkedBlockingDeque<>(5);
//        final BlockingQueue<String> buffer = new PriorityBlockingQueue<>(5);
        final BlockingQueue<String> buffer = new SynchronousQueue<>();

        // WRITER
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (char ch = 'A'; ch <= 'Z'; ch++){
                    try {
                        buffer.put("" + ch);
                        System.out.println(ch + "->");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        // READER
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(300);
                        System.out.println("->" + buffer.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



    }
}
