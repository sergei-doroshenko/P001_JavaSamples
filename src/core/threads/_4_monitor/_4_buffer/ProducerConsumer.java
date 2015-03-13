package core.threads._4_monitor._4_buffer;

/**
 * Created by Sergei on 20.02.2015.
 */
public class ProducerConsumer {
    public static void main (String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new ProducerTimed(1, 300, buffer, 10)).start();
        new Thread(new ProducerTimed(100, 500, buffer, 10)).start();
        new Thread(new ProducerTimed(1000, 700, buffer, 10)).start();

        new Thread(new ConsumerTimed(buffer, 800)).start();
        new Thread(new ConsumerTimed(buffer, 500)).start();
    }
}
