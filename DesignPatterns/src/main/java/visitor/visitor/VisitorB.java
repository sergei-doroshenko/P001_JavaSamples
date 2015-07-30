package visitor.visitor;

import visitor.element.ElementA;
import visitor.element.ElementB;

/**
 * Created by Sergei on 30.07.2015.
 */
public class VisitorB implements Visitor {

    @Override
    public void visitElementA(ElementA elementA) {
        System.out.println("VisitorB operate ElementA");
    }

    @Override
    public void visitElementB(ElementB elementB) {
        System.out.println("VisitorB operate ElementB");
    }
}
