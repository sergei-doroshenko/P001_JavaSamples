package core._4_threads._8_juc._0_jmm;

/**
 * Created by Sergei on 19.02.2015.
 */
public class AppJMM {
    static boolean ready = true;
    static int data = 0;

    public static void main (String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(1000);
                data = 1;
                //ready = true;
                System.out.println(data);
            }
        }).start();

       new Thread(new Runnable() {
            @Override
            public void run() {
                while (!ready); // if ready == true no loop
                System.out.println(data);
            }
        }).start();

    }

    private static void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
