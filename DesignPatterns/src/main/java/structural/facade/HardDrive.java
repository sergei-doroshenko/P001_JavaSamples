package structural.facade;

import java.util.Arrays;

/**
 * Created by Sergei on 08.09.2015.
 */
public class HardDrive {
    private byte[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public byte[] read(long lba, int size) {
        byte[] result = Arrays.copyOf(data, size);
        System.out.println("Hard drive " + lba + " read: " + Arrays.toString(result));
        return result;
    }
}