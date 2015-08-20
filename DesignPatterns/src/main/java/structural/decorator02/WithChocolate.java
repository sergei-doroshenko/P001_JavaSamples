package structural.decorator02;

/**
 * Created by Sergei on 20.08.2015.
 */
public class WithChocolate extends CoffeeWrapper {

    public WithChocolate(Coffee coffee) {
        super(0.8, "Chocolate", coffee);
    }
}
