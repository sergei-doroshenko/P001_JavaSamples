package creational.factory_method00;

/**
 * Created by Sergei on 14.08.2015.
 */
public class ConcreteCreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ProductA();
    }
}
