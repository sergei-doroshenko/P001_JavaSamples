package behavioral.visitor.visitor;

import behavioral.visitor.element.ElementA;
import behavioral.visitor.element.ElementB;

/**
 * Created by Sergei on 30.07.2015.
 */
public interface Visitor {
    /**
     * Element send itself visitElement(this) to visitor,
     * then visitor can make some logic under received element.
     * @param elementA
     */
    void visitElementA(ElementA elementA);
    void visitElementB(ElementB elementB);
}
