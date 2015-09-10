package behavioral.chain_of_responsibility;

/**
 * Created by Sergei on 10.09.2015.
 */
public class Client {
    public static void main(String[] args) {
        Handler chain_0 = new PositiveHandler();
        Handler chain_1 = new ZeroHandler();
        Handler chain_2 = new NegativeHandler();

        chain_0.setNext(chain_1);
        chain_1.setNext(chain_2);

        chain_0.handle(-20);
        chain_0.handle(0);
        chain_0.handle(435);
    }
}
