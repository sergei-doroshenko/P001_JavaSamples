package core._0_proc.mem._2_heap_gc;

/**
 * Created by Sergei on 25.02.2015.
 */
public class App03 {
    /**For testing set JVM option -Xmx8m to set heap size and -verbose:gc to show garbage
     * collector activities
     * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
     * or
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * @param args
     */
    public static void main(String[] args) {
        Object[] ref = new Object[1];

        while(true) {
            Object[] a = new Object[1];
            Object[] b = {a};
            ref[0] = new Object[]{a, b, ref};
        }
    }
}
