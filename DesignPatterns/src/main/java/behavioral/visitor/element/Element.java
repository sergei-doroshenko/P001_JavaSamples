package behavioral.visitor.element;

import behavioral.visitor.visitor.Visitor;

/**
 * Created by Sergei on 30.07.2015.
 */
public interface Element {
    void accept(Visitor visitor);
}
