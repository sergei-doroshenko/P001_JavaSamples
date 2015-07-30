package visitor.visitor;

import visitor.element.ElementA;
import visitor.element.ElementB;

/**
 * Created by Sergei on 30.07.2015.
 */
public class VisitorA implements Visitor {

    @Override
    public void visitElementA(ElementA elementA) {
        System.out.println("VisitorA operate ElementA");
    }

    @Override
    public void visitElementB(ElementB elementB) {
        System.out.println("VisitorA operate ElementB");
    }
}
