package core._6_oop._3_call_order;

/**
 * Created by Sergei on 17.03.2015.
 */
public class Dog extends Animal {
    public static String DOG_ID  = "DefaultDogId";

    static {
        System.out.println("Dog static block");
    }

    public String a;

    public Dog() {
        this.a = "Dog";
        System.out.println("Dog()");
    }

    {
        System.out.println("Dog NON-static");
    }
}
