package org.sergei._0_core._1_excep._2_try_with_res;

import java.util.Arrays;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App00 {
    public static void main(String[] args) throws Exception {
        try (Resource x1 = new Resource("0"); Resource x2 = new Resource("1"); Resource x3 = new Resource("2")) {
            System.err.println("try");
            throw new Exception("exc in try", new Error());
        } catch (Exception e) {
            System.err.println("catch");
            System.err.println("cause: " + e.getCause());
            System.err.println("msg: " + e.getMessage());
            System.err.println("suppressed: " + Arrays.toString(e.getSuppressed()));
        } finally {
            System.err.println("finally");
        }
    }
}
/*
new: 0
new: 1
new: 2
try
auto-close: 2
auto-close: 1
auto-close: 0
catch
cause: java.lang.Error
msg: exc in try
suppressed: [java.lang.RuntimeException, java.lang.RuntimeException, java.lang.RuntimeException]
finally
 */
