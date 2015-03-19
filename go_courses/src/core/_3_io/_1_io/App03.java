package core._3_io._1_io;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Sergei on 05.03.2015.
 */
public class App03 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/doubles.dat");

        DataOutputStream out = new DataOutputStream(
                new GZIPOutputStream(                     // decorator
                        new LogOutputStream(              // custom decorator
                            new BufferedOutputStream(           // decorator
                                    new FileOutputStream(file), 256) ) ) );

        for (int i = 0; i < 1000; i++){
            out.writeDouble(Math.random() * 100);
        }
        out.flush();
        out.close();

        DataInputStream in = new DataInputStream(
                new GZIPInputStream(
                    new FileInputStream(file) ));
        double d;

        try {
            while ( true ) {
                d = in.readDouble();
                System.out.println(d);
            }
        } catch (EOFException e) {
            System.out.println("EOF");
        }

        System.out.println("End");

    }

}

class LogOutputStream extends OutputStream {
    private final OutputStream out;

    LogOutputStream(OutputStream delegee) {
        this.out = delegee;
    }


    @Override
    public void write(int b) throws IOException {
        System.out.println("log: " + b);
        out.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        System.out.println("log: " + b.length);
        out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        System.out.println("log: " + b.length + " - " + off + " - " + len);
        out.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
