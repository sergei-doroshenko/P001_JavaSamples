package _7_inheritance;

/**
 * Created by Sergei on 04.03.2015.
 */
public class Car {
    public int gearRatio = 8;
    public String accelerate() {  return "Accelerate : Car";  }
}

abstract class GasolineCar extends Car {
    @Override
    public abstract String accelerate();
}

class SportsCar extends GasolineCar {
    public int gearRatio = 9;
    public String accelerate() {  return  "Accelerate : SportsCar";  }
    public static void main(String[] args){
        GasolineCar c = new SportsCar();
        System.out.println( c.gearRatio +"  "+c.accelerate() );
    }
}
