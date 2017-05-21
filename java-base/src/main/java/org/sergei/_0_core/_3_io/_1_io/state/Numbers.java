package org.sergei._0_core._3_io._1_io.state;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Sergei on 09.03.2015.
 */
public class Numbers extends AbstractState {
    private ByteArrayOutputStream buff = new ByteArrayOutputStream();

    public Numbers(OutputStream out) {
        super(out);
    }

    @Override
    public AbstractState next(byte value) throws IOException { // analog of doAction() method
        if (value == 0) {
            out.write(buff.toByteArray(), 0, buff.toByteArray().length);
            return new Zero(out);
        } else {
            buff.write(value);
            return this;
        }

    }


    public void finish() throws IOException {
        out.write(buff.toByteArray(), 0, buff.toByteArray().length);
    }
}
