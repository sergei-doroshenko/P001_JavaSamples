package structural.decorator;

/**
 * Created by Sergei on 20.08.2015.
 */
public class WithChocolate implements Coffee {

    private Coffee coffee;

    public WithChocolate(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return this.coffee.getCost() + 0.8;
    }

    @Override
    public String getIngredients() {
        return this.coffee.getIngredients() + " Chocolate";
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
