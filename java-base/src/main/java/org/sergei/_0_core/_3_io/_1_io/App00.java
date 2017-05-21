package org.sergei._0_core._3_io._1_io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by Sergei on 03.03.2015.
 */
public class App00 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com");

        try(InputStream inet = url.openStream();
            ByteArrayOutputStream buff = new ByteArrayOutputStream() ){

            copy(inet, buff);
            byte[] rawData = buff.toByteArray();
            String html = new String(rawData, "ascii");
            System.out.println(html);
        }
        // write to 2 output
        // handle exceptions
        // delete 2 files if failed File.delete()
        // read-write arrays


    }
    // fst, snd
    private static void copy(InputStream src, OutputStream dst) throws IOException {
        while (true) {
            int elem = src.read();
            if (elem != -1) {
                dst.write(elem);

            } else {
                break;
            }
        }
    }
}
