package _09_NIO2;

import util.IOUtils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by sergei on 12/1/15.
 */
public class _9_17_FileRead {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        RandomAccessFile file = new RandomAccessFile("plain.txt", "r");
        FileChannel channel = file.getChannel();
        StringBuilder sb = new StringBuilder();

        while ( channel.read(buffer) != -1 ) {
            System.out.println(IOUtils.info(buffer));
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.println(IOUtils.info(buffer));
                byte[] arr = new byte[buffer.limit()];
                buffer = buffer.get(arr);
                sb.append(new String(arr));
            }
            /* sb.append(new String(buffer.array(), StandardCharsets.UTF_8));*/
            buffer.clear();
        }

        System.out.println(sb);
    }
}
