package core._3_io._0_charset._0_lab;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.Iterator;

/**
 * Created by Sergei on 02.03.2015.
 */
public class MyCharsetProvider  extends CharsetProvider {
    @Override
    public Iterator<Charset> charsets() {
        return null;
    }

    @Override
    public Charset charsetForName(String charsetName) {
        return new MyCharset(charsetName, null);
    }
}
