package org.sergei._0_core._1_excep._1_try_catch_fin;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App01 {
    public static void main(String[] args) {
        try{
            //System.in.read();
            System.err.println(0);

            if (true) {
               return;
            }

            System.err.println(1);

        } catch (RuntimeException e) {
            System.err.println(2);
            throw e;
        } finally {
            System.err.println("finally");
        }

        System.err.println(4);
    }
}
/* prints:
0
finally
 */