package structural.decorator;

/**
 * Created by Sergei on 19.08.2015.
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee = new WithMilk(new WithSprinkle(new SimpleCoffee()));
        System.out.println("Cost: " + coffee.getCost());
        System.out.println("Ingredients: " + coffee.getIngredients());

        Coffee coffee2 = new WithChocolate(new WithMilk(new SimpleCoffee()));
        System.out.println("Cost: " + coffee2.getCost());
        System.out.println("Ingredients: " + coffee2.getIngredients());
    }
}
