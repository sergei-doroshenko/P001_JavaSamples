package behavioral.strategy;

/**
 * Created by Sergei on 31.07.2015.
 */
public class Context {
    private int temperatureInF;
    private Strategy strategy;

    public Context(int temperatureInF, Strategy strategy) {
        this.temperatureInF = temperatureInF;
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int getTemperatureInF() {
        return temperatureInF;
    }

    public boolean getResult() {
        return strategy.checkTemperature(temperatureInF);
    }
}
