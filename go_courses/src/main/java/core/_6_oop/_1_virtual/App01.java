package core._6_oop._1_virtual;

/**
 * Created by Sergei Doroshenko on 17.03.2015.
 *
 * Example of calling static methods
 * Resolved at compile-time
 */
public class App01 {
    public static void main(String[] args) {
        send(new ChildMessage()); // Parent STATIC call
    }

    public static void send(ParentMessage msg) {
        msg.staticCall();
    }
}
