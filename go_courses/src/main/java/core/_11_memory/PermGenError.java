package core._11_memory;

/**
 * Created by Sergei on 05.10.2015.
 */
public class PermGenError {
    public static void main(String[] args) {
        main(new String[] { (args[0] + args[0]).intern() });
    }
}