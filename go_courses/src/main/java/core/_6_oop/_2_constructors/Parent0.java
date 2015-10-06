package core._6_oop._2_constructors;

/**
 * Created by Sergei on 16.03.2015.
 */
public class Parent0 {
    protected int p;

    public Parent0() {
        System.out.println("Parent()");
    }

    public Parent0(int p) {
        this.p = p;
        System.out.println("P");
    }

    public Parent0(int x, int y) {
        System.out.println("Parent(int, int) x: " + x + ", y: " + y);
    }
}
