package structural.composite;

/**
 * Created by Sergei on 27.08.2015.
 */
public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello " + name);
    }
}
