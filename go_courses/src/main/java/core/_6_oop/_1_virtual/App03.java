package core._6_oop._1_virtual;

/**
 * Created by Sergei Doroshenko on 17.03.2015.
 *
 * Example of calling instance field
 * Resolved at compile-time
 */
public class App03 {
    public static void main(String[] args) {
        send(new ChildMessage()); // Child instance field
        // if ChildMessage doesn't have instanceField - 'Parent instance field' will be print
    }

    public static void send(ChildMessage msg) {
        System.out.println(msg.instanceField);
    }
}
