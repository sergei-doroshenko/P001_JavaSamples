package core._4_threads._4_monitor;

/**
 * Created by Sergei on 20.02.2015.
 */
public class App02 {
    public static void main (String[] args) {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            final int tmp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    hello(tmp);
                }
            }).start();
        }
    }

    public static synchronized void hello(int id) {
        System.out.println(id + " * - wait - sleep, " + System.currentTimeMillis()); // all threads pass this phase
        try {
            App02.class.wait(1000);
            // release monitor
            // than take monitor
        } catch (InterruptedException ingnore) { /* NOP */ }
        System.out.println(id + " wait - * - sleep, " + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ingnore) { /* NOP */ }
        System.out.println(id + " wait - sleep - *, " + System.currentTimeMillis());
        /*
        2 * - wait - sleep, 1424447060843 -> 60843
        1 * - wait - sleep, 1424447060843
        3 * - wait - sleep, 1424447060843
        4 * - wait - sleep, 1424447060843
        0 * - wait - sleep, 1424447060843
        0 wait - * - sleep, 1424447061843
        0 wait - sleep - *, 1424447062843
        4 wait - * - sleep, 1424447062843
        4 wait - sleep - *, 1424447063843
        1 wait - * - sleep, 1424447063843
        1 wait - sleep - *, 1424447064843
        3 wait - * - sleep, 1424447064843
        3 wait - sleep - *, 1424447065843
        2 wait - * - sleep, 1424447065843
        2 wait - sleep - *, 1424447066843 -> 66843
         */
    }
}
