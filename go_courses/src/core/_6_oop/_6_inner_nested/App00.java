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

    public static /* Nested */ Object f() { // Can't return Nested
        class Nested {}
        return new Nested();
    }

    public static void main(final String[] args) {
        Thread current = Thread.currentThread();
        Thread.State state = current.getState();
        System.out.println(.05);

        Outer outer = new Outer();
        int y = outer.y;
        /*new Outer.Inner();*/ // NO
        Outer.Inner inner = new Outer().new Inner();
        Outer.StaticNested staticNested = new Outer.StaticNested();
    }
}

class Outer {
    {
        System.out.println("Outer" + new Inner().a);
    }
    private int x = 0;
    public int y = 0;

    class Inner {
        {
            System.out.println("Inner");
        }
        private int a;
        public void m0 () {
            System.out.println("x = " + x);
        }
    }

    static class StaticNested {
        {
            System.out.println("Nested");
        }
        public void m0 () {
            /*System.out.println("x = " + x);*/ // 'x' cannot be referenced from a static context
        }
    }
}
