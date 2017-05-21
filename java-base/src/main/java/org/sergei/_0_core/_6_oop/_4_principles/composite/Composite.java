package org.sergei._0_core._6_oop._4_principles.composite;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Sergei on 18.03.2015.
 */
public class Composite implements Figure {
    private final Collection<Figure> fugures;

    public Composite(Figure... fugures) {
        this.fugures = Arrays.asList(fugures);
    }

    public void add(Figure fugure) {
        fugures.add(fugure);
    }

    @Override
    public void draw() {
        for (Figure fugure : fugures) {
            fugure.draw();
        }
    }
}
