package creational.prototype;

/**
 * Created by Sergei on 17.08.2015.
 */
public class DVD extends Product {
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DVD{" + super.toString() +
                ", duration=" + duration +
                '}';
    }
}
