package core._6_oop._6_inner_nested;

/**
 * Created by Sergei on 19.03.2015.
 */
public class App00 {


/*
    class Inner {}
    static class Nested{}
    abstract class NestedA {}
    interface NestedI {}
    enum  NestedE {}*/

    public static void main(String[] args) {
        Thread current = Thread.currentThread();
        Thread.State state = current.getState();
    }

    public static /* Nested */ Object f() { // Can't return Nested
        class Nested {}
        return new Nested();
    }
}

class Outer {
    class Inner {

    }
}
