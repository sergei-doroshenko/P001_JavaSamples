package core._3_io._1_io.adapter;

import java.io.IOException;

/**
 * Created by Sergei on 06.03.2015.
 */
public interface EntityIntput {
    Person readPerson() throws IOException;
    void close() throws IOException;
}
