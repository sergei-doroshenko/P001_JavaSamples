package behavioral.chain_of_responsibility;

/**
 * Created by Sergei on 10.09.2015.
 */
public class NegativeHandler extends AbstractHandler {

    @Override
    public void handle(Long number) {
        if (number != null && number < 0) {
            System.out.println("NegativeHandler: " + number);
        } else {
            this.next.handle(number);
        }
    }
}
