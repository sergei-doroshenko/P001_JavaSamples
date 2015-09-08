package _7_inheritance._0_call_order;

/**
 * Created by Sergei on 17.03.2015.
 */
public class Dog extends Animal {
    public static String DOG_ID  = "DefaultDogId";

    static {
        System.out.println("Dog static block");
    }

    public int a = 20;

    public Dog(int x) {

        //this.a = "Dog";
        System.out.println("Dog(int); a = " + a);
    }

    {
        System.out.println("Dog NON-static; a = " + a);
    }
}
