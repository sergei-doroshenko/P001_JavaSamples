package juc._0_http;

import sun.nio.cs.US_ASCII;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Sergei Doroshenko on 19.02.2015.
 *
 * call it in browser on http://127.0.0.2:8183/
 */
public class SocetServer {
    private static Charset US_ASCII = new US_ASCII();

    public static void main (String[] args) throws IOException {
        byte[] ipAddr = new byte[]{127, 0, 0, 2};
        InetAddress addr = InetAddress.getByAddress(ipAddr);
        ServerSocket serverSocket = new ServerSocket(8183, 2, addr); // like socket factory
        while (true) {
            System.out.println("wait for TCP-connection...");
            //todo: what certainly happens when accept
            //todo: Describe (all packages) TCP handshake
            // create new socket
            Socket socket = serverSocket.accept(); // create and return socket (TCP handshake)
            System.out.println("get one!");

            try (InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream()) {

                // READ request
                byte[] request = readRequestFully(in);
                System.out.println("----------------------------------");
                System.out.println(new String(request, US_ASCII));
                System.out.println("---------------------------------");

                // WRITE response
                byte[] response = new Date().toString().getBytes(US_ASCII);
                out.write(response);
            } finally {
                socket.close();
            }
            //todo: What happens when OS.close()/IS.close()/socet.close()
        }
    }

    private static byte[] readRequestFully(InputStream in) throws IOException {
        byte[] buff = new byte[8192];
        int headerLen = 0;
        while (true) {
            int count = in.read(buff);
            if (count < 0) {
                throw new RuntimeException("Incoming connection closed.");
            } else {
                headerLen += count;
                if (isRequestEnd(buff, headerLen)) {
                    return Arrays.copyOfRange(buff, 0, headerLen);
                }
                if (headerLen == buff.length) {
                    throw new RuntimeException("Too big HTTP header.");
                }
            }

        }
    }

    private static boolean isRequestEnd(byte[] buff, int headerLen) {
        return true;
    }
}
