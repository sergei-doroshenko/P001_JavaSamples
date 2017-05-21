package org.sergei._0_core._1_excep._2_try_with_res;

/**
 * Created by Sergei on 26.02.2015.
 */
public class ExResource implements AutoCloseable {
    private String name;

    public ExResource(String name) {
        this.name = name;
        System.err.println("new: " + name);
        throw new RuntimeException();
    }

    @Override
    public void close() throws Exception {
        System.err.println("auto-close: " + name);
    }
}
