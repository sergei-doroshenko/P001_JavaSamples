package junior._0_http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Sergei on 19.02.2015.
 */
public class SocetServer {
    public static void main (String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1024);
        while (true) {
            System.out.println("wait for TCP-connection...");
            // create new socket
            Socket socket = serverSocket.accept();
            System.out.println("get one!");

            try (InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream()) {
                byte[] request = HttpUtils.readRequestFully(in);
                System.out.println("----------------------------------");
                System.out.println(new String(request));
                System.out.println("---------------------------------");
                byte[] response = new Date().toString().getBytes();
                out.write(response);
            } finally {
                socket.close();
            }
        }
    }
}
