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
public class _9_18_ServerSocet {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(9999));

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(true) {
            SocketChannel sc = ssc.accept();
            System.out.println("get one!");
            sc.read(buffer);
            System.out.println(new String(buffer.array()));
            buffer.clear();
            byte[] response = new Date().toString().getBytes();
            buffer.put(response);
            System.out.println( sc.write(buffer) );
            sc.close();
        }
    }
}
