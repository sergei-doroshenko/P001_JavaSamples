package org.sergei._0_core._0_proc.mem._3_ref;

import java.lang.ref.SoftReference;

/**
 * Created by Sergei on 25.02.2015.
 */
public class App00 {
    public static void main(String[] args) {

        SoftReference<byte[]> ref = new SoftReference<>(new byte[100_000_000]);
        byte[] data = ref.get();

        if (data != null) {

        }
    }
}
