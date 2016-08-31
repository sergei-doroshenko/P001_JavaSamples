package core._3_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncSocketServerExample {
    private Map<SocketChannel,List> dataMapper;
    private InetSocketAddress listenAddress;

    public static void main(String[] args) throws Exception {
        Runnable server = () -> {
            try {
                new AsyncSocketServerExample("localhost", 8090).startServer();
            } catch (IOException | InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        };

        Runnable client = () -> {
            try {
                new AsyncSocketClientExample().startClient();
            } catch (IOException | InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        };

        new Thread(server).start(); // Run server in separate thread
        new Thread(client, "client-A").start(); // Run two clients in separate threads
        new Thread(client, "client-B").start();
    }

    public AsyncSocketServerExample(String address, int port) throws IOException {
        listenAddress = new InetSocketAddress(address, port);
        dataMapper = new HashMap<>();
    }

    // create server channel
    private void startServer() throws IOException, ExecutionException, InterruptedException {

        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();

        serverChannel.bind(listenAddress);

        System.out.println("Server started...");
        System.out.println("Server channel bound to port: " + listenAddress.getPort() );
        System.out.println("Waiting for client to connect... ");

        Future<AsynchronousSocketChannel> acceptResult = serverChannel.accept();
        AsynchronousSocketChannel clientChannel = acceptResult.get();

        System.out.println("Messages from client: ");


        if ( clientChannel != null && clientChannel.isOpen() ) {

            while (true) {

                ByteBuffer buffer = ByteBuffer.allocate(32);
                Future result = clientChannel.read(buffer);

                while (! result.isDone()) {
                    // do nothing
                }

                buffer.flip();
                String message = new String( buffer.array() ).trim();
                System.out.println( message );

                if (message.equals("Bye.")) {

                    break; // while loop
                }

                buffer.clear();

            } // while()

            clientChannel.close();

        } // end-if

        serverChannel.close();
    }

    //accept a connection made to this channel's socket
    private void accept( SelectionKey key ) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel channel = serverChannel.accept();
        channel.configureBlocking(false);
        Socket socket = channel.socket();
        SocketAddress remoteAddr = socket.getRemoteSocketAddress();
        System.out.println("Connected to: " + remoteAddr);

        // register channel with selector for further IO
        dataMapper.put(channel, new ArrayList());

    }

    //read from the socket channel
    private void read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int numRead = -1;
        numRead = channel.read(buffer);

        if (numRead == -1) {
            this.dataMapper.remove(channel);
            Socket socket = channel.socket();
            SocketAddress remoteAddr = socket.getRemoteSocketAddress();
            System.out.println("Connection closed by client: " + remoteAddr);
            channel.close();
            key.cancel();
            return;
        }

        byte[] data = new byte[numRead];
        System.arraycopy(buffer.array(), 0, data, 0, numRead);
        System.out.println("Got: " + new String(data));
    }
}