package core._1_excep._1_try_catch_fin;

import java.io.IOException;

/**
 * Created by Sergei on 27.02.2015.
 */
public class App04 {
    public static void main(String[] args) { // !!! NO Exception declaration !!!

        try {

            throw new IOException();

        } catch (Exception e) {

            throw new Exception();

        } finally {

            throw new RuntimeException(); // not exception declaration in method signature
        }
    }
}
