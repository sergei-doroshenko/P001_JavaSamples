package _5_loops;

/**
 * Created by Sergei on 12.03.2015.
 */
public class App_for {
    private App_for(){}




    public static void main(String[] arr) {

        for(;Math.random()<0.5;) {
            System.out.println("true");
        }

        /*for(;;Math.random()<0.5){
            System.out.println("true");
        }*/

        for(;;) {
            if (Math.random() < .05) break;
        }

        for(;;Math.random()){
            System.out.println("true");
        }

        // both parts of ?-expression must return the same type, not void.
        /*for(;;){
            Math.random()<.05 ? break : continue;
        }*/



    }

}
