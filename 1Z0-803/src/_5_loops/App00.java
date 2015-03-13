package _5_loops;

/**
 * Created by Sergei on 03.03.2015.
 */
public class App00 {
    public static void main(String[] args) {
        one: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {

                if (i < j) continue one;
                System.out.println(i + " " + j);
                if (i > j) break one;

            }
        }

        System.out.println("end");

        block : { break block ; }

        /*  valid loop  */
        for (;Math.random()<.05;);

    }
}
