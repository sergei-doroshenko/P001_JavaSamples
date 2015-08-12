package behavioral.strategy;

/**
 * Created by Sergei on 31.07.2015.
 */
public class SkiStrategy implements Strategy {

    @Override
    public boolean checkTemperature(int temperatureInF) {
        if (temperatureInF <= 32) {
            return true;
        } else {
            return false;
        }
    }
}
