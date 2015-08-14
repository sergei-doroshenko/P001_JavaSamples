package creational.factory_method02;

/**
 * Created by Sergei on 14.08.2015.
 */
public abstract class Animal {
    Animal(){}

    public static Animal create(String type) {
        switch (type) {
            case "Cat" : return new Cat();
            case "Dog" : return new Dog();
            default: return new Dog();
        }
    }

    abstract String voice();
}
