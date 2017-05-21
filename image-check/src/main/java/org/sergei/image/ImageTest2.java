package org.sergei.image;

import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by sergei on 11/18/15.
 */
public class ImageTest2 {
    public static void main(String[] args) throws IOException, ImageReadException {
        File file = new File("image.jpg");
        final ImageInfo imageInfo = Imaging.getImageInfo(file);
        System.out.println(imageInfo);

        InputStream is = new FileInputStream(file);

        final int i1 = is.read();
        final int i2 = is.read();
        final int[] bytePair = { i1, i2, };
        if (Arrays.equals(bytePair, new int[] { 0x89, 0x50, })) { // png
            System.out.println("png");
            int h1;

            while ( (h1 = is.read()) != -1) {
                if (h1 == 0x49 && is.read() == 0x48 && is.read() == 0x44 && is.read() == 0x52) {
                    System.out.println("Found IHDR.");
                    byte[] chunk = new byte[13];
                    int r = is.read(chunk);
                    if (r != -1) {
                        for (byte b : chunk) {
                            System.out.printf("%02X ", b);
                        }
                        System.out.println();
                        if (chunk[9] == 0x02) {
                            System.out.println("Found RGB color type.");
                        }
                        System.out.println("----------------------------");
                    }
                    break;
                }
            }
        } else if (Arrays.equals(bytePair, new int[] { 0xff, 0xd8, })) { // jpg
            System.out.println("jpg");
            int r1;
            while ( (r1 = is.read()) != -1) {
                if (r1 == 0xff && is.read() == 0xda) {
                    byte[] length = new byte[2];
                    is.read(length);
                    ByteBuffer wrapped = ByteBuffer.wrap(length); // big-endian by default
                    int len = wrapped.getShort(); // 1
                    System.out.println("Header length: " + len);

                    byte[] data = new byte[len];
                    int r = is.read(data);
                    if (r != -1) {
                        for (byte b : data) {
                            System.out.printf("%02X ", b);
                        }
                        System.out.println();
                        if (data[0] == 0x03) {
                            System.out.println("Found RGB color type.");
                        }
                        System.out.println("----------------------------");
                    }
                    break;
                }
            }
        }


        //System.out.println(String.valueOf(new char[]{0x49, 0x48, 0x44, 0x52})); // IHDR
    }
}
