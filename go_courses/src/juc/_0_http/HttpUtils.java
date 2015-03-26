package juc._0_http;

import sun.nio.cs.US_ASCII;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by Sergei Doroshenko on 25.03.2015.
 */
public class HttpUtils {

    public static Charset US_ASCII = new US_ASCII();

    /**
     * HEADER_END - bytes array represents the end of http header.
     * Namely, characters sequence: \r\n\r\n or CR\LF\CR\LF
     * |----------------------|-------|--------------------|
     * |       Name           |  char | Unicode codePoint  |
     * |----------------------|-------|--------------------|
     * | CARRIAGE RETURN (CR) |  '\r' |        13          |
     * | LINE FEED (LF)       |  '\n' |        10          |
     * |----------------------|-------|--------------------|
     *  so the new byte[]{13, 10, 13, 10} is analog of
     *  new byte[]{'\r', '\n', '\r', '\n'}
     */
    public static byte[] HEADER_END = new byte[]{13, 10, 13, 10};

    public static byte[] readRequestFully(InputStream in) throws IOException {
        byte[] buff = new byte[8192];
        int headerLen = 0;
        while (true) {
            int count = in.read(buff, headerLen, buff.length - headerLen);
            if (count < 0) {
                throw new RuntimeException("Incoming connection closed.");
            } else {
                headerLen += count;
                if (isMessageEnd(buff, headerLen)) {
                    return Arrays.copyOfRange(buff, 0, headerLen);
                }
                if (headerLen == buff.length) {
                    throw new RuntimeException("Too big HTTP header.");
                }
            }

        }
    }

    public static byte[] createResponse(String message) {
        return (message + new String(HttpUtils.HEADER_END)).getBytes(HttpUtils.US_ASCII);
    }

   public static boolean isMessageEnd(byte[] buff, int lenght) {
        if (lenght < 4) return false;

        byte[] tail = Arrays.copyOfRange(buff, lenght - 4, lenght);
        return Arrays.equals(tail, HEADER_END);
    }

    public static void main(String[] args) {
        /*char c0 = '\n';
        System.out.println("-" + c0 + "-");
        char c1 = '\r';
        int i = c1;
        System.out.println("-" + i + "-");*/
        char c2 = 13;
        System.out.println("-" + c2 + "-");
        String c3 = "\u0031";
        System.out.println("-" + c3 + "-");
        System.out.println(Character.getName(13));

    }
}
