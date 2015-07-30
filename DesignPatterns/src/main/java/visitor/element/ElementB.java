package visitor.element;

import visitor.visitor.Visitor;

/**
 * Created by Sergei on 30.07.2015.
 */
public class ElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }
}
