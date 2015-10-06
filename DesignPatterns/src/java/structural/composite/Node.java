package structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 27.08.2015.
 */
public class Node implements ComponentGroup {
    private List<Component> children = new ArrayList<>();

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public Component getChild(int index) {
        return children.get(index);
    }

    @Override
    public void sayHello() {
        for (Component c : children) {
            c.sayHello();
        }
    }
}
