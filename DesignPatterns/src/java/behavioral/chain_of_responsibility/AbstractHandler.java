package behavioral.chain_of_responsibility;

/**
 * Created by Sergei on 10.09.2015.
 */
public abstract class AbstractHandler implements Handler {
    protected Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }
}
