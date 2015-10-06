package structural.decorator02;

/**
 * Created by Sergei on 20.08.2015.
 */
public class WithSprinkle extends CoffeeWrapper {

    public WithSprinkle(Coffee coffee) {
        super(0.3, "Sprinkle", coffee);
    }
}
