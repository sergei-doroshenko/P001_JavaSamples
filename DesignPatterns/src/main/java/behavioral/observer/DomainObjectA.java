package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 31.07.2015.
 */
public class DomainObjectA implements Observable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        observer.setState(Observer.State.ATTACHED);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        observer.setState(Observer.State.DETACHED);
    }

    @Override
    public void fireEvent() {
        String message = "Hi, guys!";
        observers.stream().forEach(observer -> observer.update(message));
    }
}
