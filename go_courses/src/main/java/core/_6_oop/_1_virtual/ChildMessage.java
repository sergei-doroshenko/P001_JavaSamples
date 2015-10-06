package core._6_oop._1_virtual;

/**
 * Created by Sergei Doroshenko on 17.03.2015.
 */
public class ChildMessage extends ParentMessage {

    public static String ST_FIELD = "Child static field";

    public String instanceField = "Child instance field";

    public static void staticCall() {
        System.out.println("Child STATIC call");
    }

    @Override
    public void call() {
        System.out.println("Child call");
    }
}
