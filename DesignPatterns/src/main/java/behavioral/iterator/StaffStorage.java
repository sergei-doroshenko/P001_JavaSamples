package behavioral.iterator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergei on 08.09.2015.
 */
public class StaffStorage {
    private List<String> list = Arrays.asList(new String[] {"one", "two", "three", "------"});

    public StaffStorage() { }

    public Iterator getIterator(IteratorType type) {
        switch (type) {
            case FORWARD: return new ForwardStaffIterator(this);
            case REVERSE: return new ReverseStaffIterator(this);
            default: return new ForwardStaffIterator(this);
        }
    }

    protected List<String> getList() {
        return list;
    }

    protected void setList(List<String> list) {
        this.list = list;
    }

    public interface Iterator {
        String next();
    }

    public enum IteratorType {
        FORWARD, REVERSE
    }
}
