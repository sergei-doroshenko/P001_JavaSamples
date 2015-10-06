package core.lib;

/**
 * Created by Sergei on 21.02.2015.
 */
public class Processors {
    public static void main (String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);
        System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));
    }
}
