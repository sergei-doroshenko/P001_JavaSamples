package org.sergei.image;

import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;

import java.io.FileInputStream;
import java.io.InputStream;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by sergei on 11/18/15.
 */
public class ImageTest {
    public static void main(String[] args) throws IOException, ImageReadException {
//        File file = new File("/home/sergei/Documents/img/_thumb_95742.tiff");
        File file = new File("/home/sergei/Documents/img/_thumb_95742.png");
//        File file = new File("google_faico.jpg");
//        File file = new File("/home/sergei/Documents/img/thumb_95742-CMYK.png");
        final ImageInfo imageInfo = Imaging.getImageInfo(file);
        System.out.println(imageInfo);

        if(imageInfo.getColorType() == ImageInfo.ColorType.CMYK){

        } else {

        }

        InputStream is = new FileInputStream(file);


        /*byte[] marker = new byte[] {(byte) 0xff, (byte) 0xda};
        byte[] buffer = new byte[2];
        int result;
        while ( (result = is.read(buffer)) != -1) {
            if (Arrays.equals(buffer, marker)) {
                System.out.println(Integer.toHexString(is.read()));
                System.out.println(Integer.toHexString(is.read()));
                System.out.println(Integer.toHexString(is.read()));
                System.out.println("----------------------------");
            }
        }*/

        int r1, r2;
        while ( (r1 = is.read()) != -1) {
            if (r1 == 0xff && (r2 = is.read()) == 0xda) {
                System.out.printf("%02X %02X : ", r1, r2);
                System.out.printf("[%02X %02X %02X]\n", is.read(), is.read(), is.read());
                System.out.println("----------------------------");
            }
        }

    }
    /*

    InputStream is = new FileInputStream(file);

    if (numberOfComponents == 3) {
        colorType = ImageInfo.ColorType.RGB;
    } else if (numberOfComponents == 4) {
        colorType = ImageInfo.ColorType.CMYK;
    }


     */

}
