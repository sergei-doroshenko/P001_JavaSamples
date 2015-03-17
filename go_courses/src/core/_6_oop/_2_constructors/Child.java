package core._6_oop._2_constructors;

/**
 * Created by Sergei on 16.03.2015.
 */
public class Child extends Parent {
    protected int c;

    public Child(){
        System.out.println("Child()");
    }

    public Child(int x) {
        System.out.println("Child(int) x: " + x);
    }

    public Child(int p, int c) {
        super(p);
        this.c = c;
        System.out.println("C");
    }
}
