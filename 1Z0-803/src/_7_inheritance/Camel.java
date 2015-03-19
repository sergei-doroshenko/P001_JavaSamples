package _7_inheritance;

/**
 * Created by Sergei on 04.03.2015.
 */
interface Rideable {
    String getGait();
}

public class Camel implements Rideable {
    int weight = 2;

    public static void main(String[] args) {
        new Camel().go(8);
    }

    void go(int speed) {
        ++speed;
        weight++;
        int walkrate = speed * weight;
        System.out.print(walkrate + getGait());
    }

    public String getGait() { // compilation error if --> without public <-- String getGait()
        return " mph, lope";
    }
}
