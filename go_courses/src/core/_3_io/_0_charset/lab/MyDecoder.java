package core._3_io._0_charset.lab;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/**
 * Created by Sergei on 02.03.2015.
 */
public class MyDecoder extends CharsetDecoder {
    /**
     * Initializes a new decoder.  The new decoder will have the given
     * chars-per-byte values and its replacement will be the
     * string <tt>"&#92;uFFFD"</tt>. </p>
     *
     * @param cs
     * @param averageCharsPerByte A positive float value indicating the expected number of
     *                            characters that will be produced for each input byte
     * @param maxCharsPerByte     A positive float value indicating the maximum number of
     *                            characters that will be produced for each input byte
     * @throws IllegalArgumentException If the preconditions on the parameters do not hold
     */
    protected MyDecoder(Charset cs, float averageCharsPerByte, float maxCharsPerByte) {
        super(cs, averageCharsPerByte, maxCharsPerByte);
    }

    @Override
    protected CoderResult decodeLoop(ByteBuffer in, CharBuffer out) {
        return null;
    }
}
