package _5_loops;
import static java.lang.System.*;
import static java.lang.System.out;
/**
 * Created by Sergei on 12.03.2015.
 */
public class App_for {
    private App_for(){}

    {
        for(; true; ) break;
    }


    public static void main(String[] arr) {

        int c = 0;
        JACK: while (c < 8){
            JILL: System.out.println("c = " + c);
            for(int k = 0; k<c; k++){
                System.out.println(" k = " + k + " c = " + c);
                if (c > 3) break JACK;
            }
            c++;
        }

        int c1 = 0;
        JACK: while (c1 < 8){
            JILL: System.out.println(c);
            if (c1 > 3) break JACK; else c++;
        }


        for(;Math.random()<0.5;) {
            out.println("true");
        }

        /*for(;;Math.random()<0.5){
            System.out.println("true");
        }*/

        for(;;) {
            if (Math.random() < .05) break;
        }

        for(;;Math.random()){
            out.println("true");
        }

        // both parts of ?-expression must return the same type, not void.
        /*for(;;){
            Math.random()<.05 ? break : continue;
        }*/



    }

}
