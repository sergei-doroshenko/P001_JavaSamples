package _2_data_types.str;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App01 {
    public static void main(String[] args) {
        System.out.println("String".replace('g','G') == "String".replace('g','G'));

        System.out.println("String".replace('g','G') == "StrinG");

        System.out.println("String".replace('g','g') == "String");
    }
}
