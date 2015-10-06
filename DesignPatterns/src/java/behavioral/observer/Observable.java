package behavioral.observer;

/**
 * Created by Sergei on 31.07.2015.
 */
public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void fireEvent();
}
