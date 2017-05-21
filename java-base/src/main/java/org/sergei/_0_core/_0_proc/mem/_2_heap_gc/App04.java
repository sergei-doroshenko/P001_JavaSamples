package org.sergei._0_core._0_proc.mem._2_heap_gc;

/**
 * Created by Sergei on 25.02.2015.
 */
public class App04 {
    public static void main(String[] args) {
        int k = 0;
        while (true) {
            Fin f = new Fin(k++);
        }
    }
}

class Fin {
    private int index;
    private byte[] data = new byte[1_000_000];

    public Fin(int index) {
        this.index = index;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Bye!" + index);
        while (true);
    }
}
