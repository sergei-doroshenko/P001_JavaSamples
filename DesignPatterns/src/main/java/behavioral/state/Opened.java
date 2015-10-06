package behavioral.state;

/**
 * Created by Sergei on 17.08.2015.
 */
public class Opened implements State {

    @Override
    public void handle(Door door) {
        System.out.println("Door is close");
        door.setState(new Closed());
    }
}
