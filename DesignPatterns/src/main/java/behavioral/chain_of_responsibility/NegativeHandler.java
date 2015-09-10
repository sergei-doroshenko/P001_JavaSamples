package behavioral.chain_of_responsibility;

/**
 * Created by Sergei on 10.09.2015.
 */
public class NegativeHandler extends AbstractHandler {

    @Override
    public void handle(int number) {
        if (number < 0) {
            System.out.println("NegativeHandler: " + number);
        } else {
            this.next.handle(number);
        }
    }
}
