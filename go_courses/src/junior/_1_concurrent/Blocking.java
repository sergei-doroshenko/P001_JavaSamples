package junior._1_concurrent;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Sergei on 24.05.2015.
 */
public class Blocking {
    Deque<String> gangOfFour = new LinkedBlockingDeque<>();

    class Producer extends Thread {
        String[] authors = {"E Gamma", "R Johnson", "R Helm", "J Vlissides"};

        @Override
        public void run() {
            for (String author : authors) {
                gangOfFour.add(author);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // ignore it
                }
            }
        }
    }

    class Consumer extends Thread {
        int numOfAuthors = 4;
        int processedAuthors = 0;

        @Override
        public void run() {
            while (processedAuthors < 4) {
                while (gangOfFour.isEmpty()) {
                    /*wait*/
                }
                System.out.println(gangOfFour.remove());
                processedAuthors++;
            }
        }
    }

    public static void main(String[] args) {
        Blocking blocking = new Blocking();
        blocking.new Producer().start();
        blocking.new Consumer().start();
    }
}
