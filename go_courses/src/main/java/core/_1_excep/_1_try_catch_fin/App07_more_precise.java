package core._1_excep._1_try_catch_fin;

/**
 * Created by Sergei on 17.03.2015.
 *
 * More precise rethrow
 */
public class App07_more_precise {
    public static void main(String[] args) {
        try {
            throw new Error();
        } catch (Throwable e) {
            throw e; // NO need to add throws clause in method declaration
        }
    }
}
