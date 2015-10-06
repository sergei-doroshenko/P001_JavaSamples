package structural.decorator02;

/**
 * Created by Sergei on 20.08.2015.
 */
public class SimpleCoffee implements Coffee {

    private double cost;
    private String ingredient;

    public SimpleCoffee(double cost, String ingredient) {
        this.cost = cost;
        this.ingredient = ingredient;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public String getIngredients() {
        return this.ingredient;
    }
}
