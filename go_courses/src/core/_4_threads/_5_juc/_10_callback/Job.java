package core._4_threads._5_juc._10_callback;

import core.lib.ThreadUtils;
/**
 * Created by Sergei on 09.04.2015.
 */
public class Job implements Runnable {
    private final long id;
    private final Callback callback;

    public Job(final long id, final Callback callback) {
        this.id = id;
        this.callback = callback;
    }

    public void run() {
        String message = "T-" + Thread.currentThread().getId();
        System.out.println(message + " started...");
        for (int i = 0; i <= 100; i++) {
            ThreadUtils.sleep(10);
            if (i % 10 == 0) callback.callback(id, i, i == 100);
        }
    }
}
