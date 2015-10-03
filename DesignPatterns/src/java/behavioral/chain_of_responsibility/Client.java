package behavioral.chain_of_responsibility;

/**
 * Created by Sergei on 10.09.2015.
 */
public class Client {
    public static void main(String[] args) {
        Handler chain_0 = new PositiveHandler();
        Handler chain_1 = new ZeroHandler();
        Handler chain_2 = new NegativeHandler();
        Handler chain_3 = new ErrorHandler();

        chain_0.setNext(chain_1);
        chain_1.setNext(chain_2);
        chain_2.setNext(chain_3);

        chain_0.handle(-20L);
        chain_0.handle(0L);
        chain_0.handle(435L);
        chain_0.handle(null);
    }
}
