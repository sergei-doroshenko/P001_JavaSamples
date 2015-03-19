package _5_loops;

/**
 * Created by Sergei on 28.02.2015.
 */
public class App01 {
    public static void main(String[] args) {
        int var = 20, i = 0;
        do{
            while(true){
                if( i++ > var) break;
            }
        } while(i < var--);
        System.out.println(var);

    }
}