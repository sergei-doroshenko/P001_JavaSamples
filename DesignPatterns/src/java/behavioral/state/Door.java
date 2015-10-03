package behavioral.state;

/**
 * Created by Sergei on 17.08.2015.
 */
public class Door {
    private State state;

    public Door(State state) {
        this.state = state;
    }

    public void request() {
        this.state.handle(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
