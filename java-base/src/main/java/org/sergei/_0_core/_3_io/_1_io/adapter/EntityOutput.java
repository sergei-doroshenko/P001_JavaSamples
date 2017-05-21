package org.sergei._0_core._3_io._1_io.adapter;

import java.io.IOException;

/**
 * Created by Sergei on 06.03.2015.
 */
public interface EntityOutput {
    void writePerson(Person person) throws IOException;
    void flush() throws IOException;
    void close() throws IOException;
}
