package org.sergei._0_core._1_excep._1_try_catch_fin;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App00 {
    public static void main(String[] args) {
        try{
            //System.in.read();
            System.err.println(0);

            if (true) {
                throw new RuntimeException("Hello!");
            }

            System.err.println(1);

        } catch (RuntimeException e) {
            System.err.println(2);
            throw e;
        }
        catch (Throwable t){
            System.err.println(3);
        } finally {
            System.err.println("finally");
            if (true) throw new RuntimeException("F");
        }

        System.err.println(4);

    }
}
