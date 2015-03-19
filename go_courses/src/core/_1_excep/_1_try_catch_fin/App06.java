package core._1_excep._1_try_catch_fin;

/**
 * Created by Sergei on 02.03.2015.
 */
public class App06 {
    public static void main(String[] args) {
        try {
            System.out.println("T");
            int x = 1/0;
        } finally {
            System.out.println("F");
        } /*catch (Exception e) {
            System.out.println("C");
        }*/
        /* would not compile */
    }
}
