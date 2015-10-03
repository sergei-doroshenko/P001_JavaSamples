package creational.factory_method01;

/**
 * Created by Sergei on 14.08.2015.
 */
public class App00 {
    public static void main(String[] args) {

        Product product0 = Product.factoryMethod();
        System.out.println(product0.getClass().getSimpleName());

        Product product1 = Product.factoryMethod("B");
        System.out.println(product1.getClass().getSimpleName());
    }
}
