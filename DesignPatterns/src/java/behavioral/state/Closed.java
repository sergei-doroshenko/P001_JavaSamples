package behavioral.state;

/**
 * Created by Sergei on 17.08.2015.
 */
public class Closed implements State {

    @Override
    public void handle(Door door) {
        System.out.println("Door is open");
        door.setState(new Opened());
    }
}
