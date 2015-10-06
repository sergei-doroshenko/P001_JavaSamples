package behavioral.observer;

/**
 * Created by Sergei on 31.07.2015.
 */
public class App {
    public static void main(String[] args) {
        Observable observable = new DomainObjectA();

        observable.attach(new ObserverA());
        observable.attach(new ObserverB());

        observable.fireEvent();
    }
}
