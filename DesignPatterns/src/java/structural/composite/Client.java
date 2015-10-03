package structural.composite;

/**
 * Created by Sergei on 27.08.2015.
 */
public class Client {
    public static void main(String[] args) {
        Component leaf0 = new Leaf("Jhon");
        Component leaf1 = new Leaf("Mike");
        Component leaf2 = new Leaf("Frank");
        Component leaf3 = new Leaf("Suzy");
        Component leaf4 = new Leaf("Sarah");
        Component leaf5 = new Leaf("Maria");

        ComponentGroup composite0 = new Node();
        composite0.add(leaf0);
        composite0.add(leaf1);
        composite0.add(leaf2);

        ComponentGroup composite1 = new Node();
        composite1.add(leaf3);
        composite1.add(leaf4);
        composite1.add(leaf5);

        ComponentGroup composite2 = new Node();
        composite2.add(composite0);
        composite2.add(composite1);

        System.out.println("Calling 'sayHello' on leaf0");
        leaf0.sayHello();

        System.out.println("\nCalling 'sayHello' on composite0");
        composite0.sayHello();

        System.out.println("\nCalling 'sayHello' on composite1");
        composite1.sayHello();

        System.out.println("\nCalling 'sayGoodbye' on composite2");
        composite2.sayHello();
    }
}
