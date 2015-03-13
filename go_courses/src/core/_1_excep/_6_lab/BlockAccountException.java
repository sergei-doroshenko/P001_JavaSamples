package core._1_excep._6_lab;

/**
 * Created by Sergei on 28.02.2015.
 */
public class BlockAccountException extends Exception {

    public BlockAccountException(String message) {
        super(message);
    }

    public BlockAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
