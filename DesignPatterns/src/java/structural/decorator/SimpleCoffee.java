package structural.decorator;

/**
 * Created by Sergei on 20.08.2015.
 */
public class SimpleCoffee implements Coffee {

    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Coffee";
    }
}
