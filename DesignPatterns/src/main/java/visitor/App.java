package visitor;

import visitor.element.Element;
import visitor.element.ElementA;
import visitor.element.ElementB;
import visitor.visitor.Visitor;
import visitor.visitor.VisitorA;
import visitor.visitor.VisitorB;

/**
 * Created by Sergei on 30.07.2015.
 */
public class App {
    public static void main(String[] args) {

        Visitor visitor = new VisitorA();

        Element e0 = new ElementA();
        e0.accept(visitor);

        Element e1 = new ElementB();
        e1.accept(visitor);

        Visitor visitorB = new VisitorB();
        e0.accept(visitorB);
        e1.accept(visitorB);
    }
}
