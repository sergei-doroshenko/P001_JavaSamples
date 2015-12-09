package _09_NIO2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

/**
 * Created by sergei on 12/1/15.
 */
public class _9_18_ServerSoket_nio {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(9999));
        ssc.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(true) {
            System.out.println("Waiting for connections");
            SocketChannel sc = ssc.accept();
            if (sc == null) {
                Thread.sleep(2000);
            } else {
                System.out.println("Incoming connection from: " + sc.socket().getRemoteSocketAddress());
                sc.read(buffer);
                System.out.println(new String(buffer.array()));
                buffer.clear();

                String response = "Hello " + sc.socket().getInetAddress() + " on port "
                        + sc.socket().getPort() + "\r\n";
                response += "This is " + sc.socket() + " on port "
                        + sc.socket().getLocalPort() + "\r\n";
                response += new Date().toString() + "\r\n";

                byte[] data = response.getBytes("UTF-8");

                buffer.put(data);
                buffer.flip();
                // or another approach to use wrap method
                // ByteBuffer buf = ByteBuffer.wrap(data);

                while (buffer.hasRemaining())
                    sc.write(buffer);
                sc.close();
            }
        }
    }
}
