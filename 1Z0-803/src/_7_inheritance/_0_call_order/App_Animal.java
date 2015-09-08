package _7_inheritance._0_call_order;

/**
 * Created by Sergei on 17.03.2015.
 */
public class App_Animal {
    public static void main(String[] args) {
        test0();

    }

    public static void test0() {
        Animal ref = new Dog(300);
        /*Animal static block
        Dog static block
        Animal NON-static block
        Animal()
        Dog NON-static
        Dog()*/
    }

    public static void test1() {
        System.out.println(Dog.ANIMAL_ID);
       /* Animal static block
         NewAnimalID*/
    }

    public static void test2() {
        System.out.println(Dog.DOG_ID);
       /* Animal static block
        Dog static block
        DefaultDogId*/
    }
}
