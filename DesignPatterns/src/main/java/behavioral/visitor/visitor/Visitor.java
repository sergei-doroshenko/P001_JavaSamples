package behavioral.visitor.visitor;

import behavioral.visitor.element.ElementA;
import behavioral.visitor.element.ElementB;

/**
 * Created by Sergei on 30.07.2015.
 */
public interface Visitor {
    void visitElementA(ElementA elementA);
    void visitElementB(ElementB elementB);
}
