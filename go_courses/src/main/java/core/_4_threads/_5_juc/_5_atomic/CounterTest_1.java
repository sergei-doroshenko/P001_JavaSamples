package core._4_threads._5_juc._5_atomic;

/**
 * Created by Sergei on 09.04.2015.
 */
public class CounterTest_1 {
    public static final int N = 1_000_000_000;
    static /*volatile*/ int counter = 0;
    static synchronized void increment() {
        counter++;
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    increment();
                }
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    increment();
                }
            }
        });
        t0.start();
        t1.start();

        t0.join();
        t1.join();

        System.out.printf("%,d", counter);

    }
}
