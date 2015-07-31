package behavioral.visitor;

import behavioral.visitor.element.Element;
import behavioral.visitor.element.ElementA;
import behavioral.visitor.element.ElementB;
import behavioral.visitor.visitor.Visitor;
import behavioral.visitor.visitor.VisitorA;
import behavioral.visitor.visitor.VisitorB;

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
