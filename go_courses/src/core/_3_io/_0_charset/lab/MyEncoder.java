package core._3_io._0_charset.lab;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.BitSet;

/**
 * Created by Sergei on 02.03.2015.
 */
public class MyEncoder extends CharsetEncoder {

    protected MyEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar) {
        super(cs, averageBytesPerChar, maxBytesPerChar);
    }

    @Override
    protected CoderResult encodeLoop(CharBuffer in, ByteBuffer out) {
        /*for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            System.out.println(c);
        }*/
        CoderResult cr;

        BitSet bitSet = new BitSet();
        int ind = 0;
        while (in.hasRemaining()) {
            char ch = in.get();
            System.out.println(ch);

            if (ch == 'A') { // 00
                bitSet.set(ind++, false);
                bitSet.set(ind++, false);
            } else if (ch == 'B') { // 01
                bitSet.set(ind++, false);
                bitSet.set(ind++, true);
            } else if (ch == 'C') { // 10
                bitSet.set(ind++, true);
                bitSet.set(ind++, false);
            } else { // 11
                bitSet.set(ind++, true);
                bitSet.set(ind++, true);
            }

            if (bitSet.length() > 8) {
                byte b = bitSet.toByteArray()[0];
                System.out.println(b);
                out.put(b);
                bitSet.clear();
            }


        }
        cr = CoderResult.UNDERFLOW;
        return cr;
    }
}
