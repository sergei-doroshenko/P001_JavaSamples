package core._3_io._0_charset._0_lab;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.Arrays;
import java.util.ServiceLoader;
import java.util.Set;

/**
 * Created by Sergei on 02.03.2015.
 */
public class MyCharsetApp {
    public static void main(String[] args) throws RuntimeException, UnsupportedEncodingException {
        ServiceLoader<CharsetProvider> load = ServiceLoader.load(CharsetProvider.class);

        for (CharsetProvider elem : load) {
            CharsetProvider provider = elem;
            System.out.println(provider);
        }

        Set<String> charsetNames = Charset.availableCharsets().keySet();
        for (String name : charsetNames) {
            System.out.println("Charset: " + name);
        }

        Charset cs = new SergeiCharsetProvider().charsetForName("X-DORO");
        byte[] bytes = "AAABBBCCC".getBytes(cs);
        System.out.println(Arrays.toString(bytes));

        //System.out.println(new String(bytes, cs));

    }
}
