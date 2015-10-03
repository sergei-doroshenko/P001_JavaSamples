package structural.decorator;

/**
 * Created by Sergei on 20.08.2015.
 */
public class WithSprinkle implements Coffee {

    private Coffee coffee;

    public WithSprinkle(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return this.coffee.getCost() + 0.3;
    }

    @Override
    public String getIngredients() {
        return this.coffee.getIngredients() + " Sprinkle";
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
