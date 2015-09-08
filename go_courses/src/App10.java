/**
 * Created by Sergei on 27.02.2015.
 */
import static java.lang.System.*;
public class App10 {
    public static void main(String[] args) {

        out.println("");

        for(;;){
            if(Math.random()<.05) break;
        }



    }


}

class ABCD{
    int x = 10;
    static int y = 20;
}
class MNOP extends ABCD{
    int x = 30;
    static int y = 40;
}
