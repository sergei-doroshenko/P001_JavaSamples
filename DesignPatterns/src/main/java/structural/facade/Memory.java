package structural.facade;

import java.util.Arrays;

/**
 * Created by Sergei on 08.09.2015.
 */
public class Memory {
    public void load(int position, byte[] data) {
        final byte[] temp = new byte[data.length - position];
        System.arraycopy(data, position, temp, 0, temp.length);
        System.out.println("Memory loads: " + Arrays.toString(temp));
    }
}

