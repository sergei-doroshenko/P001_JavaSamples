package creational.factory_method02;

/**
 * Created by Sergei on 14.08.2015.
 */
public class Client {
    public static void main(String[] args) {
        Animal cat = Animal.create("Cat");
        System.out.println(cat.voice());

        Animal dog = Animal.create("Dog");
        System.out.println(dog.voice());
    }
}
