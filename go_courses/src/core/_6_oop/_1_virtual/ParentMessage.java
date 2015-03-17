package core._6_oop._1_virtual;

/**
 * Created by Sergei Doroshenko on 17.03.2015.
 */
public class ParentMessage {
    public static String ST_FIELD = "Parent static field";

    public String instanceField = "Parent instance field";

    public static void staticCall() {
        System.out.println("Parent STATIC call");
    }

    public void call() {
        System.out.println("Parent call");
    }
}
