package creational.factory_method01;

/**
 * Created by Sergei on 14.08.2015.
 */
public abstract class Product {
    Product(){}

    public static Product factoryMethod() {
        return new ProductA();
    }

    public static Product factoryMethod(String letterCode) {
        switch (letterCode) {
            case "A" : return new ProductA();

            case "B" : return new ProductB();

            default: return new ProductA();
        }
    }
}
