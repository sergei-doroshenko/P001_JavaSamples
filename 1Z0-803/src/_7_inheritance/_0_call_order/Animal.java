package _7_inheritance._0_call_order;

/**
 * Created by Sergei on 17.03.2015.
 */
public class Animal {
    public static String ANIMAL_ID = "DefaultAnimalID";

    static {
        ANIMAL_ID = "NewAnimalID";
        System.out.println("Animal static block");
    }

    public int a = 10;

    public Animal() {

        System.out.println("Animal(); a = " + a);
    }

    {
        System.out.println("Animal NON-static block; a = " + a);
    }
}
