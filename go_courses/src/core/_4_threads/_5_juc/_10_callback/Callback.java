package core._4_threads._5_juc._10_callback;

/**
 * Created by Sergei on 09.04.2015.
 */
public interface Callback {
    void callback(long jobId, int data, boolean isCompleted);
}
