package juc._0_http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by Sergei Doroshenko on 19.02.2015.
 *
 * call it in browser on http://127.0.0.2:8183/
 */
public class HttpServer01 {


    public static void main (String[] args) throws IOException {
        byte[] ipAddr = new byte[]{127, 0, 0, 2};
        InetAddress addr = InetAddress.getByAddress(ipAddr);
        final ServerSocket serverSocket = new ServerSocket(8183, 4, addr); // like socket factory

//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ExecutorService threadPool = new ThreadPoolExecutor(
                4, 64,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(256)
        );

        while (true) {
            System.out.println("wait for TCP-connection...");
            //todo: what certainly happens when accept
            //todo: Describe (all packages) TCP handshake
            // create new socket

            Socket socket = serverSocket.accept(); // create and return socket (TCP handshake)
            System.out.println("get one!");

            threadPool.submit(new HttpHandler(socket));
        }
    }
}

class HttpHandler implements Callable<String> {
    private final Socket socket;

    public HttpHandler(Socket soket) {
        this.socket = soket;
    }

    @Override
    public String call() throws Exception {
        String result = null;
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {

            // READ request
            byte[] request = HttpUtils.readRequestFully(in);
            result = new String(request, HttpUtils.US_ASCII);
            System.out.println("----------------------------------");
            System.out.print(result);
            System.out.println("---------------------------------");

            // WRITE response
            byte[] response = HttpUtils.createResponse(new Date().toString());
            out.write(response);
        } finally {
            socket.close();
        }

        return result;
    }
}
