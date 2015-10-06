package core._4_threads._5_juc._5_atomic;

/**
 * Created by Sergei on 09.04.2015.
 */
public class CounterTest_0 {
    public static final int N = 1_000_000_000;
    static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter++;
                }
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter++;
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
