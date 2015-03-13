package _3_operators_if_else;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App02_switch {
    public static void main(String[] args) {

        switch (1) {
            default: break;
        }

        switch (2) {
            default: break;
            case 2: System.out.println(2);
        }

        switch (3) {
            case 'n': System.out.println(3);
        }

        int x = 0;
        switch(x){
        }

        // switch(8); // !!! NOT VALID !!!

    }
}
