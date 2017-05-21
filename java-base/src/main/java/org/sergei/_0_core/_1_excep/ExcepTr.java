package org.sergei._0_core._1_excep;

import java.io.IOException;

/**
 * Created by Sergei on 25.02.2015.
 */
public class ExcepTr {
    int id;

    public void t() throws IOException {
        System.out.println("call t");
    }

    public static void main(String[] args) {
        System.out.println("return: " + test());
        int x = 1/0;
    }

    private static int test() {
        ExcepTr excepTr = new ExcepTr();
        try {
            excepTr.t();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        } finally {
            System.out.println("fin");
            //return 2;
        }
    }
}
