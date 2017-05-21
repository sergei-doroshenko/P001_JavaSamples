package org.sergei._0_core._1_excep._0_base;

import java.awt.*;

/**
 * Created by Sergei on 26.02.2015.
 */
public class Printer {
    private Font font;



    public Printer(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("font == null");
            // or
            //this.font = Font.getFont(Font.SANS_SERIF);
        }
        this.font = font;
    }

    public void print(String doc) throws PrintemException {

        if (doc == null || doc.isEmpty() ) {
            throw new IllegalArgumentException("doc invalid");
        }

        if (System.nanoTime() % 2 == 0) {
            throw new PrintemException(10, 105, "Document");
        }
        //System.out.println();
    }
}
