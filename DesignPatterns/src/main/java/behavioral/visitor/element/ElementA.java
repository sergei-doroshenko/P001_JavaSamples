package behavioral.visitor.element;

import behavioral.visitor.visitor.Visitor;

/**
 * Created by Sergei on 30.07.2015.
 */
public class ElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }
}
