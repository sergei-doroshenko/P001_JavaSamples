package behavioral.chain_of_responsibility;

/**
 * Created by Sergei on 10.09.2015.
 */
public class ErrorHandler extends AbstractHandler {

    @Override
    public void handle(Long number) {
        System.out.println("Error while handle request.");
    }
}
