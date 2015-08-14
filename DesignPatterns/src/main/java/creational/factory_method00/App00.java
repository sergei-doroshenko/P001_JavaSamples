package creational.factory_method00;

/**
 * Created by Sergei on 14.08.2015.
 */
public class App00 {
    public static void main(String[] args) {
        Creator creator0 = new ConcreteCreatorA();
        Product product0 = creator0.factoryMethod();
        System.out.println(product0.getClass().getSimpleName());

        Creator creator1 = new ConcreteCreatorB();
        Product product1 = creator1.factoryMethod();
        System.out.println(product1.getClass().getSimpleName());
    }
}
