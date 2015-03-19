package _1_java_basics._0_keywords;

/**
 * Created by Sergei on 19.03.2015.
 */
public class App00 {
    public /*synchronized*/ int i;

    public /*synchronized*/ String str;

    /**
     * synchronized keyword may be applied to method or block only
     */

    public void m0 () {
        synchronized (this) {
            System.out.println("sync block");
        }
    }

    public synchronized void m1 () {
        System.out.println("sync method");
    }

}
