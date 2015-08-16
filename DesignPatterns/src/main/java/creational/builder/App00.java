package creational.builder;

/**
 * Created by Sergei on 16.08.2015.
 */
public class App00 {
    public static void main(String[] args) {
        BodyMassIndex index = new BodyMassIndex.Bulder()
                .age(35)
                .weight(82)
                .height(174)
                .build();

        double result = index.calculate();

        System.out.println(result);
    }
}
