package core._6_oop._2_constructors;

/**
 * Created by Sergei on 16.03.2015.
 */
public class Parent {
    protected int p;

    public Parent() {
        System.out.println("Parent()");
    }

    public Parent(int p) {
        this.p = p;
        System.out.println("P");
    }

    public Parent(int x, int y) {
        System.out.println("Parent(int, int) x: " + x + ", y: " + y);
    }
}
