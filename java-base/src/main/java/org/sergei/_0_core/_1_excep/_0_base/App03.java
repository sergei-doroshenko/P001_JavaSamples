package org.sergei._0_core._1_excep._0_base;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App03 {
    public static void main(String[] args) {
        try{
            throw new NullPointerException();
        } catch (RuntimeException e) {
            System.out.println("RE");
        } catch (Throwable t) {
            System.out.println("T");
        }

    }
}
