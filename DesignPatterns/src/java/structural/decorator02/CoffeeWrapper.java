package structural.decorator02;

/**
 * Created by Sergei on 20.08.2015.
 */
public abstract class CoffeeWrapper implements Coffee {

    private double cost;
    private String ingredient;
    private Coffee coffee;

    public CoffeeWrapper(double cost, String ingredient, Coffee coffee) {
        this.cost = cost;
        this.ingredient = ingredient;
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return this.coffee.getCost() + this.cost;
    }

    @Override
    public String getIngredients() {
        return this.coffee.getIngredients() + " - " + this.ingredient;
    }
}
