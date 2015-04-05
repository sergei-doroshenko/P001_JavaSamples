package _1_java_basics;

/**
 * Created by Sergei on 24.03.2015.
 */
public class App04 {
    public static void main(String[] args) {
        int i0 = 100;

        float f0 = 123;
        float f1 = 5.5f;
        /**
         * !!! need CAST !!!
         */
        float f2 = (float) 5.5;
        float f3 = i0;


        double d0 = 123;
        double d1 = 3.5;
        double d2 = 3.5d;
        double d3 = i0;
        double d4 = f1;

        int i1 = (int) 3.5;
        i1 = (int) f0;
        i1 = (int) d1;

        System.out.println(3 + 5.2); // 8.2
    }
}
