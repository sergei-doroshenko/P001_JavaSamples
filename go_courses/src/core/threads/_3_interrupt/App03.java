package core.threads._3_interrupt;

/**
 * Created by Sergei on 20.02.2015.
 */
public class App03 {
    public static void main (String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread myThread = Thread.currentThread(); // return link to current thread
                while (true) {
                    System.out.println(myThread.isInterrupted());
                    try {
                        Thread.sleep(1_000_000_000);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                        break; // or return
                    }
                }
            }
        });

        t1.start();
        Thread.sleep(1000);
        t1.interrupt(); // this flag is used for inform the thread to finish it's work
    }
}
