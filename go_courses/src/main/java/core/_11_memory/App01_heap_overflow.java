package core._11_memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 05.10.2015.
 * This code results in
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * when run.
 */
public class App01_heap_overflow {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        for (;;) {
            System.out.println(i++);
            list.add(new Object[1_000_000]);
        }
    }
}
