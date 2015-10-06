package core._3_io._0_charset._0_lab;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by Sergei on 02.03.2015.
 */
public class SergeiCharset extends Charset {
    /**
     * Initializes a new charset with the given canonical name and alias
     * set. </p>
     *
     * @param canonicalName The canonical name of this charset
     * @param aliases       An array of this charset's aliases, or null if it has no aliases
     * @throws java.nio.charset.IllegalCharsetNameException If the canonical name or any of the aliases are illegal
     */
    protected SergeiCharset(String canonicalName, String[] aliases) {
        super(canonicalName, aliases);
    }

    @Override
    public boolean contains(Charset cs) {
        return false;
    }

    @Override
    public CharsetDecoder newDecoder() {
        return new MyDecoder(this, 4, 4);
    }

    @Override
    public CharsetEncoder newEncoder() {
        return new MyEncoder(this, 1, 1);
    }
}
