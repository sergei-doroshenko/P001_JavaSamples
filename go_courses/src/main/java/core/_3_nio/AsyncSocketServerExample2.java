package core._3_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncSocketServerExample2 {
    private Map<SocketChannel,List> dataMapper;
    private InetSocketAddress listenAddress;

    public static void main(String[] args) throws Exception {
        Runnable server = () -> {
            try {
                new AsyncSocketServerExample2("localhost", 8090).startServer();
                Thread.sleep( 6000 );
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

    public AsyncSocketServerExample2(String address, int port) throws IOException {
        listenAddress = new InetSocketAddress(address, port);
        dataMapper = new HashMap<>();
    }

    // create server channel
    private void startServer() throws IOException, ExecutionException, InterruptedException {

        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();

        serverChannel.bind(listenAddress);

        System.out.println("Server started...");
        System.out.println("Server channel bound to port: " + listenAddress.getPort() );
        System.out.println("Waiting for client to connect... ");

        // Listen for a new request
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel ch, Void attachment) {
                // Accept the next connection
                serverChannel.accept( null, this );

                // Greet the client
                ch.write( ByteBuffer.wrap( "Hello, I am Echo Server 2020, let's have an engaging conversation!\n".getBytes() ) );

                // Allocate a byte buffer (4K) to read from the client
                ByteBuffer byteBuffer = ByteBuffer.allocate( 4096 );

                // Read the first line
                int bytesRead;
                try {
                    // The read() returns a Future<Integer> on which we can invoke get()
                    // to retrieve the number of bytes read from the client
                    // if we do not get a response in 20 seconds then the get() method will throw a TimeoutException.
                    bytesRead = ch.read( byteBuffer ).get( 20, TimeUnit.SECONDS );

                    boolean running = true;
                    while( bytesRead != -1 && running )
                    {
                        System.out.println( "bytes read: " + bytesRead );

                        // Make sure that we have data to read. If the client sends an empty line
                        // then we receive two bytes: a carriage return and a line feed.
                        // Mean that client should sent message like "\n\r".
                        if( byteBuffer.position() > 2 )
                        {
                            // Make the buffer ready to read
                            byteBuffer.flip();

                            // Convert the buffer into a line
                            byte[] lineBytes = new byte[ bytesRead ];
                            byteBuffer.get( lineBytes, 0, bytesRead );
                            String line = new String( lineBytes );

                            // Debug
                            System.out.println( "Message: " + line );

                            // Echo back to the caller
                            ch.write( ByteBuffer.wrap( line.getBytes() ) );

                            // Make the buffer ready to write (... to write in the buffer)
                            byteBuffer.clear();

                            // Read the next line
                            bytesRead = ch.read( byteBuffer ).get( 20, TimeUnit.SECONDS );

                        }
                        else
                        {
                            // An empty line signifies the end of the conversation in our protocol
                            running = false;
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    // The user exceeded the 20 second timeout, so close the connection
                    ch.write( ByteBuffer.wrap( "Good Bye\n".getBytes() ) );
                    System.out.println( "Connection timed out, closing connection" );
                    System.out.println( "End of conversation" );

                } catch (ExecutionException e) {
                    // Execution exception occurs
                    ch.write( ByteBuffer.wrap( "Good Bye\n".getBytes() ) );
                    System.out.println( "Execution error, closing connection" );
                    System.out.println( "End of conversation" );
                } finally {
                    try {
                        // Close the connection if we need to
                        if( ch.isOpen() )
                        {
                            ch.close();
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("Failed...");
            }
        });

        System.out.println("After accept...");
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