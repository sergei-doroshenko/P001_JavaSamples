package org.sergei._0_core._1_excep._1_try_catch_fin;

/**
 * Created by Sergei on 26.02.2015.
 * insert:
 * throw new NullPointerException();
 * throw new RuntimeException();
 * throw new IOException();
 * throw new Error();
 */
public class App05_lab {
    public static void main(String[] args) {
        System.err.print(0 + " ");
        try {
            System.err.print(1 + " ");
            if (true) { throw new Error(); }
            System.err.print(2 + " ");
        } catch (NullPointerException e) {
            System.err.print(3 + " ");
            if (true) {            }
            System.err.print(4 + " ");
        } catch (RuntimeException e) {
            System.err.print(5 + " ");
            if (true) {            }
            System.err.print(6 + " ");
        } catch (Exception e) {
            System.err.print(7 + " ");
            if (true) {            }
            System.err.print(8 + " ");
        } finally {
            System.err.print(9 + " ");
            if (true) {            }
            System.err.print(10 + " ");
        }
        System.err.print(11 + " ");
    }
}
