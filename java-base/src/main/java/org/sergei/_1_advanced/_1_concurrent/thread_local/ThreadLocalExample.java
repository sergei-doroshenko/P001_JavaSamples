package org.sergei._1_advanced._1_concurrent.thread_local;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Sergei_Doroshenko on 10/31/2016.
 * <p>
 * The output is different for two threads:
 * [0, 1]       // for 1st thread
 * [0, 1, 2, 3] // for second thread
 */
public class ThreadLocalExample {

    public static class Shareable {
        private ThreadLocal<List<Integer>> keeper = new ThreadLocal<>();

        public void execute() {
            this.keeper.set(new ArrayList<>());
            int to = new Random().nextInt(5) + 1;
            IntStream.range(0, to).forEach(i -> keeper.get().add(i));
            System.out.println(keeper.get());
        }
    }

    public static void main(String[] args) {
        // creates shareable instance
        Shareable tester = new Shareable();
        // operate with shareable instance in different threads
        new Thread(() -> tester.execute()).start();
        new Thread(() -> tester.execute()).start();
    }


}
