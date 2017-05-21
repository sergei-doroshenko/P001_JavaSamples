package org.sergei._0_core._1_excep._2_try_with_res;

/**
 * Created by Sergei on 27.02.2015.
 */
public class App02 {
    public static void main(String[] args) throws Exception {
        try (ResourceEx r0 = new ResourceEx("0")) {
            try (ResourceEx r1 = new ResourceEx("1")){
                /*NOP*/
            } catch (Exception e) {
                System.err.println("catch-0");
            }
        }
    }
}
