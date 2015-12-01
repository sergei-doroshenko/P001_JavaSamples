package util;

import java.nio.Buffer;
import java.util.Scanner;

/**
 * Created by sergei on 11/10/15.
 */
public class IOUtils {
    public static String readString() {
        try ( Scanner sc = new Scanner(System.in) ) {
            String line = sc.nextLine();
            return line;
        }
    }

    public static String[] readArgs() {
        return readString().split("\\s");
    }

    public static String info(Buffer buffer) {
        return "capacity: " + buffer.capacity() + ", limit: " + buffer.limit() + ", position: " + buffer.position();
    }

}
