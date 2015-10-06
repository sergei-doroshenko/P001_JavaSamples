package core._1_excep._0_base;

import java.awt.*;

/**
 * Created by Sergei on 26.02.2015.
 */
public class App02 {
    public static void main(String[] args) {

        try {
            new Printer(Font.getFont(Font.SANS_SERIF)).print("Hello, world");
        } catch (PrintemException e) {
            e.printStackTrace();
        }

    }

}
