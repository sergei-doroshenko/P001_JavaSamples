package _7_inheritance;

/**
 * Created by Sergei on 10.03.2015.
 */
public class App05 {
    public static void main(String[] args) {
        Flyer f = new Eagle();
        Eagle e = new Eagle();
        Bat b = new Bat();

        if(f instanceof Flyer) System.out.println("f is a Flyer");
        if(e instanceof Bird) System.out.println("e is a Bird");
        /* compilation error: b will never be a Bird (if b - subclass of Bat,
        it can't be subclass of Bird) */
        // if(b instanceof Bird) System.out.println("f is a Bird");
        /* !!!! BUT !!!! */
        if (b instanceof Flyer) System.out.println("b is a Flyer"); // because Flyer is an interface
    }
}

interface Flyer{ }
class Bird implements Flyer { }
class Eagle extends Bird { }
class Bat { }
