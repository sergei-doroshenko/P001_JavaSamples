package org.sergei._0_core._3_io._1_io;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * Created by Sergei on 05.03.2015.
 */
public class App02 {
    public static void main(String[] args) throws IOException {

        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        for (int i = 0; i < 10; i++) {
            buff.write(new byte[] {0, 1, 2});
        }
        byte[] bytes = buff.toByteArray();
        System.out.println(Arrays.toString(bytes));

        StringWriter writer = new StringWriter();
        for (int i = 0; i < 10; i++)
            writer.write(new char[]{'h', 'e', 'l', 'l', 'o', ' '});
        String string = writer.toString();
        System.out.println(string);

        CharArrayWriter chWriter = new CharArrayWriter();
        for (int i = 0; i < 10; i++) {
            chWriter.write(new char[]{'h', 'e', 'l', 'l', 'o', ' '});
        }
        System.out.println(chWriter.toCharArray());

    }

}
