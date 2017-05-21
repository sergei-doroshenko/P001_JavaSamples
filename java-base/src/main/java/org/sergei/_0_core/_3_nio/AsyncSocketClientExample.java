package org.sergei._0_core._3_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncSocketClientExample {

    public void startClient() throws IOException, InterruptedException, ExecutionException {

        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8090);
        Future future = client.connect(hostAddress);
        future.get(); // returns null

        System.out.println("Client... started");

        String threadName = Thread.currentThread().getName();

        // Send messages to server
        String [] messages = new String []
                {threadName + ": test1",threadName + ": test2", threadName + ": test3", "Bye.", "\n\r"};

        for (int i = 0; i < messages.length; i++) {
            byte [] message = new String(messages [i]).getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            Future result = client.write(buffer);

            while (! result.isDone()) {
                System.out.println("... ");
            }

            System.out.println(messages [i]);

            buffer.clear();
            Thread.sleep(1000);
        }
        System.out.println("Client " + threadName + " closed...");
        client.close();
    }
}