package core._1_excep;

import core.lib.ThreadUtils;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App04_global_handler {
    public static void main(String[] args) {

        Handler handler = new Handler();
        Thread.setDefaultUncaughtExceptionHandler(handler);

        // first thread handle by default handler
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start...");
                ThreadUtils.sleep(1000);
                throw new RuntimeException("Throw from MyThread");
            }
        }, "MyThread").start();

        // second thread handle by custom handler
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start...");
                ThreadUtils.sleep(1000);
                throw new RuntimeException("Throw from MyThread");
            }
        }, "Thread-2");
        t2.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("======+++Throwable e: " + e.getMessage());
                System.out.println("======+++Thread: " + t.toString());
            }
        });
        t2.start();

        throw new RuntimeException("Throw from main");
    }

}

class Handler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Throwable e: " + e.getMessage());
        System.out.println("Thread: " + t.toString());
    }
}