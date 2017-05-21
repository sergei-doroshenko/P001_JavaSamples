package org.sergei._0_core._6_oop._1_virtual;

/**
 * Created by Sergei Doroshenko on 17.03.2015.
 *
 * Example of calling static field
 * Resolved at compile-time
 */
public class App04 {
    public static void main(String[] args) {
        send(new ChildMessage()); // Parent static field

        /** !!! NOTE !!! **/
        ParentMessage ref = null;
        /** No NullPointerException **/
        System.out.println(ref.ST_FIELD); // Parent static field
        ref.staticCall();                 // Parent STATIC call
    }

    public static void send(ParentMessage msg) {
        System.out.println(msg.ST_FIELD);
    }
    // if change to send(ChildMessage msg) - 'Child static field' will print

}
