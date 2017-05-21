package org.sergei._0_core._3_io._0_charset._0_lab;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Sergei on 02.03.2015.
 */
public class SergeiCharsetProvider extends CharsetProvider {
    // The name of the charset we provide
    private static final String CHARSET_NAME = "X-DORO";

    // A handle to the Charset object
    private Charset doro = null;

    /**
     * Constructor, instantiate a Charset object and save the reference.
     */
    public SergeiCharsetProvider() {
        this.doro = new SergeiCharset (CHARSET_NAME, new String [0]);
    }

    /**
     * Called by Charset static methods to find a particular named
     * Charset.  If it's the name of this charset (we don't have
     * any aliases) then return the Rot13 Charset, else return null.
     */
    public Charset charsetForName (String charsetName) {
        if (charsetName.equalsIgnoreCase (CHARSET_NAME)) {
            return (doro);
        }

        return (null);
    }

    /**
     * Return an Iterator over the set of Charset objects we provide.
     * @return An Iterator object containing references to all the
     *  Charset objects provided by this class.
     */
    public Iterator charsets() {
        HashSet<Charset> set = new HashSet (1);

        set.add (doro);

        return (set.iterator());
    }
}
