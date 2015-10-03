package behavioral.state;

/**
 * Created by Sergei on 17.08.2015.
 */
public class App00 {
    public static void main(String[] args) {
        Door door = new Door(new Closed());
        door.request();
        door.request();
        door.request();

    }
}
