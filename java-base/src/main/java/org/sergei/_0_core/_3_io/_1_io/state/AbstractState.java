package org.sergei._0_core._3_io._1_io.state;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Sergei on 09.03.2015.
 */
public abstract class AbstractState {
    protected final OutputStream out;

    public AbstractState(OutputStream out) {
        this.out = out;
    }

    public abstract AbstractState next(byte value) throws IOException;

    abstract public void finish() throws IOException;
}
