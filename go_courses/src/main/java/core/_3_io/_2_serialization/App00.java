package core._3_io._2_serialization;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Sergei on 10.03.2015.
 */
public class App00 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(buff);

        out.writeObject("hello");
        out.writeObject(new Integer(123));
        out.writeObject(new byte[][] { {1}, {2,3}, {30} } );

        out.flush();
        out.close();

        byte[] rawData = buff.toByteArray();
        System.out.println(rawData.length);
        System.out.println(Arrays.toString(rawData));
        System.out.println(new String(rawData, "utf8"));

        ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(rawData));
        String s0 = (String) in.readObject();
        System.out.println(s0);
        System.out.println(in.readObject());
        System.out.println(Arrays.deepToString((byte[][]) in.readObject()) );

        try {
            String sss = "Hello".getClass().newInstance();
            System.out.println("sss = " + sss.length());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
