package org.sergei._1_advanced._0_http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Sergei Doroshenko on 19.02.2015.
 *
 * call it in browser on http://127.0.0.2:8183/
 */
public class HttpServer00 {


    public static void main (String[] args) throws IOException {
        byte[] ipAddr = new byte[]{127, 0, 0, 2};
        InetAddress addr = InetAddress.getByAddress(ipAddr);
        ServerSocket serverSocket = new ServerSocket(8183, 4, addr); // like socket factory

//        ServerSocket serverSocket = new ServerSocket(83);

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
                byte[] request = HttpUtils.readRequestFully(in);
                System.out.println("----------------------------------");
                System.out.print(new String(request, HttpUtils.US_ASCII));
                System.out.println("---------------------------------");

                // WRITE response
                byte[] response = (new Date().toString() + new String(HttpUtils.HEADER_END) ).getBytes(HttpUtils.US_ASCII);
                out.write(response);
            } finally {
                socket.close();
            }
            //todo: What happens when OS.close()/IS.close()/socet.close()
        }
    }


}
