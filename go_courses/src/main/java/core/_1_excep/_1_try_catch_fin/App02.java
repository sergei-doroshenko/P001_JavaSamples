package core._1_excep._1_try_catch_fin;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App02 {
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
        } finally {
            System.err.println("finally");
            return; // !!! there is NO Exception !!!
        }

    }
}
/* prints:
0
2
finally
 */