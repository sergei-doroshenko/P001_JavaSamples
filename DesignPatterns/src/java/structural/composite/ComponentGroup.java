package structural.composite;

import java.util.List;

/**
 * Created by Sergei on 27.08.2015.
 */
public interface ComponentGroup extends Component {
    void add(Component component);
    void remove(Component component);
    List<Component> getChildren();
    Component getChild(int index);
}
