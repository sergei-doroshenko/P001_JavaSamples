package org.sergei._0_core._3_io._1_io.state;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Sergei on 09.03.2015.
 */
public class Zero extends AbstractState {

    public Zero(OutputStream out) {
        super(out);
    }

    @Override
    public AbstractState next(byte value) throws IOException {
        if (value == 0) {
            return this;
        } else {
            return new Numbers(out).next(value);
        }
    }

    @Override
    public void finish() throws IOException {

    }
}
