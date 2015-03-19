package core._1_excep._2_try_with_res;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App01 {
    public static void main(String[] args) throws Exception {

        try (Resource r0 = new Resource("0");
             Resource r1 = new Resource("1");
             ResourceEx r2 = new ResourceEx("2")) {

            System.err.println("try");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
