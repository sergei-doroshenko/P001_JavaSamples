package org.sergei._0_core.lib;

/**
 * Created by Sergei on 20.02.2015.
 */
public class ThreadUtils {
    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
