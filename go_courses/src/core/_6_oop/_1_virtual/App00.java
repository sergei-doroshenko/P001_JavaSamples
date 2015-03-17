package core._6_oop._1_virtual;

/**
 * Created by Sergei Doroshenko on 17.03.2015.
 *
 * Example of calling instance (virtual) methods
 * Resolved at run-time
 */
public class App00 {
    public static void main(String[] args) {
        send(new ChildMessage()); // Child call
    }

    public static void send(ParentMessage msg) {
        msg.call();
    }
}
