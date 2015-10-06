package core._6_oop._1_virtual;

/**
 * Created by Sergei Doroshenko on 17.03.2015.
 *
 * Example of calling instance field
 * Resolved at compile-time
 */
public class App02 {
    public static void main(String[] args) {
        send(new ChildMessage()); // Parent instance field
    }

    public static void send(ParentMessage msg) {
        System.out.println(msg.instanceField);
    }
}
