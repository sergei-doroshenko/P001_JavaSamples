package _5_loops;

/**
 * Created by Sergei on 24.03.2015.
 */
public class App02_for {
    private int j;

    void showJ(){
        while(j<=5){
            for(int j=1; j <= 5;){
                System.out.print(j+" ");
                j++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        new App02_for().showJ();
    }
}
