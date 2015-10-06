package core._3_io._1_io.state;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Arrays;

/**
 * Created by Sergei on 18.03.2015.
 *
 * Remove double bytes from byte array using STATE pattern
 */
public class AppState {
    public static void main(String[] args) throws MalformedURLException {

        byte[] bytes = {0, 0, 10, 12, 1, 3, 0, 0, 0, 4, 7, 1, 0, 0, 5, 8}; // 16

        try(InputStream in = new ByteArrayInputStream(bytes);
            ByteArrayOutputStream out = new ByteArrayOutputStream()
        ) {
            filter(in, out, 8);
            byte[] b0 = out.toByteArray();
            System.out.println(Arrays.toString(b0));
        } catch (IOException e0) {
            /* NOP */
        }
    }

    public static void filter(InputStream src, OutputStream dst, int buffSize) throws IOException {
        byte[] buff = new byte[buffSize];

        while ( src.read(buff) != -1 ) {
            AbstractState state = new Zero(dst);
            for (int i = 0; i < buff.length; i++) {
                state = state.next(buff[i]);
            }
            state.finish();
        }
    }
}
