package core._3_io._1_io;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Sergei on 03.03.2015.
 */
public class App01 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com");

        try (InputStream inet = url.openStream();
            OutputStream file = new FileOutputStream(new File("d:/google.html")) ) {
            OutputStream out = new BufferedOutputStream(file, 64 * 1024);
            OutputStream out2 = new GZIPOutputStream(out);
            copy1(inet, out);
        } catch (IOException e0) {

        }

        byte[] bytes = {0, 0, 10, 12, 1, 3, 0, 0, 0, 4, 7, 1, 0, 0, 5, 8}; // 16

        try(InputStream in = new ByteArrayInputStream(bytes);
            ByteArrayOutputStream out = new ByteArrayOutputStream()
            ) {
            filter1(in, out, 8);
            byte[] b0 = out.toByteArray();
            System.out.println(Arrays.toString(b0));
        } catch (IOException e0) {

        }


    }

    // fst, snd
    private static void copy1(InputStream src, OutputStream dst) throws IOException {
        byte[] buff = new byte[1024];
        int count;

        while ( (count = src.read(buff)) != -1 ) {
            dst.write(buff, 0, count);
        }
    }

    public static void filter(InputStream src, OutputStream dst, int buffSize) throws IOException {
        final int ZER0_STATE = 0;
        final int NUMBERS_STATE = 1;
        byte[] buff = new byte[buffSize];
        int count;
        while ( (count = src.read(buff)) != -1 ) {
            int state = ZER0_STATE;
            int from = 0;
            for (int i = 0; i < buff.length; i++) {
                switch (state) {
                    case ZER0_STATE:
                        if (buff[i] == 0) {
                            state = ZER0_STATE;
                        } else {
                            from = i;
                            state = NUMBERS_STATE;
                        }
                        break;
                    case NUMBERS_STATE :
                        if (buff[i] == 0) {
                            dst.write(buff, from, i - from);
                            state = ZER0_STATE;
                        } else {
                            state = NUMBERS_STATE;
                        }
                        break;
                }
            }
            if (state == NUMBERS_STATE) {
                dst.write(buff, from, count - from);
            }
        }
    }

    public static void filter1(InputStream src, OutputStream dst, int buffSize) throws IOException {
        final int ZER0_STATE = 0;
        final int NUMBERS_STATE = 1;
        byte[] buff = new byte[buffSize];
        int count;
        while ( (count = src.read(buff)) != -1 ) {
            int state = ZER0_STATE;
            int from = 0;
            for (int i = 0; i < buff.length; i++) {
                if (state == ZER0_STATE && buff[i] != 0) {
                    from = i;
                    state = NUMBERS_STATE;
                } else if (state == NUMBERS_STATE && buff[i] == 0) {
                    dst.write(buff, from, i - from);
                    state = ZER0_STATE;
                }
            }
            if (state == NUMBERS_STATE) {
                dst.write(buff, from, count - from);
            }
        }
    }

    /*public static void filter2(InputStream src, OutputStream dst, int buffSize) throws IOException {
        byte[] buff = new byte[buffSize];
        int count;
        while ( (count = src.read(buff)) != -1 ) {
            State state = new Zero(dst);
            for (int i = 0; i < buff.length; i++) {
                state = state.next(buff[i]);
            }
            state.finish();
        }
    }*/
}
