package core._1_excep._1_try_catch_fin;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App04_lab {
    public static void main(String[] args) {
        System.err.println(0);
        try {
            System.err.println(1);
            if (true) {
                /*throw new NullPointerException();*/
            }
            System.err.println(2);
        } catch (RuntimeException e) {
            System.err.println(3);
            if (true) {

            }
            System.err.println(4);
        } finally {
            System.err.println(5);
            if (true) {

            }
            System.err.println(6);
        }
        System.err.println(7);
    }
}
