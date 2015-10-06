package behavioral.observer;

/**
 * Created by Sergei on 31.07.2015.
 */
public abstract class AbstractObserver implements Observer {
    private Observer.State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
