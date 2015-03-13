package core._3_io._1_io.state;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Sergei on 09.03.2015.
 */
public abstract class State {
    protected final OutputStream out;

    public State(OutputStream out) {
        this.out = out;
    }

    public abstract State next(byte value) throws IOException;

    abstract public void finish() throws IOException;
}
