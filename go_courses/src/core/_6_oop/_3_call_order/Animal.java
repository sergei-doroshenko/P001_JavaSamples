package core._6_oop._3_call_order;

/**
 * Created by Sergei on 17.03.2015.
 */
public class Animal {
    public static String ANIMAL_ID = "DefaultAnimalID";

    static {
        ANIMAL_ID = "NewAnimalID";
        System.out.println("Animal static block");
    }

    public int a;

    public Animal() {
        this.a = 10;
        System.out.println("Animal()");
    }

    {
        System.out.println("Animal NON-static block");
    }
}
