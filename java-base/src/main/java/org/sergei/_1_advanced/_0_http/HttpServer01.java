package org.sergei._1_advanced._0_http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Created by Sergei Doroshenko on 19.02.2015.
 *
 * call it in browser on http://127.0.0.2:8183/
 */
public class HttpServer01 {
    public static void main (String[] args) throws IOException {
        final byte[] ipAddr = new byte[]{127, 0, 0, 2};
        final InetAddress addr = InetAddress.getByAddress(ipAddr);
        final ServerSocket serverSocket = new ServerSocket(8183, 4, addr); // like socket factory

//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        final ExecutorService threadPool = new ThreadPoolExecutor(
                4, 64, // min, max threads number
                60L, TimeUnit.SECONDS, // time that idle threads will wait for new tasks before terminating
                new ArrayBlockingQueue<Runnable>(256) // the queue to use for holding tasks before they are executing
        );
        // todo: What happens when all threads are busy and queue is overload.
        while (true) {
            System.out.println("wait for TCP-connection...");
            final Socket socket = serverSocket.accept(); // create and return socket (TCP handshake)
            System.out.println("get one!");
            threadPool.submit(new HttpHandler(socket));
        }
    }
}
