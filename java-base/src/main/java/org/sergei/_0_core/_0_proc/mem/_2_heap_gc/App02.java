package org.sergei._0_core._0_proc.mem._2_heap_gc;

/**
 * Created by Sergei on 25.02.2015.
 */
public class App02 {
    /**For testing set JVM option -Xmx8m to set heap size and -verbose:gc to show garbage
     * collector activities
     * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
     * or
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * @param args
     */
    public static void main(String[] args) {
        Object ref = new Object[1];
        int counter = 0;
        while(true) {
            ref = new Object[]{ref, new byte[100_000]};
            System.out.println(counter++);
        }
    }
}
