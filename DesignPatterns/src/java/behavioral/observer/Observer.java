package behavioral.observer;

/**
 * Created by Sergei on 31.07.2015.
 */
public interface Observer {
    void update(String message);

    /**
     * There is a question about this 'state'.
     * It may decrease low coupling and cause code repeat.
     * Abstract class?
     */
    enum State {ATTACHED, DETACHED}
    void setState(State state);
    State getState();

}
