package core._6_oop._6_inner_nested;

/**
 * Created by Sergei on 19.03.2015.
 */
public class App01 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run");
            }
        }).start();
    }
}
