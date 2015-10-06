package core._4_threads._5_juc._10_callback;

import java.util.List;

/**
 * Created by Sergei on 09.04.2015.
 */
public class MessageCallback implements Callback {
    private final List<Callback> callbackList;

    public MessageCallback(List<Callback> callbackList) {
        this.callbackList = callbackList;
        callbackList.add(this);
    }

    @Override
    public void callback(long jobId, int data, boolean isCompleted) {
        System.out.println("job: " + jobId + " completion: " + data + "%");
        if (isCompleted) {
            System.out.println("job: " + jobId + " completed.");
            callbackList.remove(this);
        }
    }
}
