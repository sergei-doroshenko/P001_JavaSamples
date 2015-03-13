package core._1_excep._1_try_catch_fin;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App03 {
    static int count;
    public static void main(String[] args) {
        System.out.println(count++);
        try {
            main(args);
        } catch (StackOverflowError e) {
            main(args);
        }

    }
}
