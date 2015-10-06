package behavioral.iterator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergei on 08.09.2015.
 */
public class StaffStorage {
    private List<String> list = Arrays.asList(new String[] {"one", "two", "three"});
    private StaffIterator iterator;

    public StaffStorage() {
        this.iterator = (StaffIterator) new ForwardStaffIterator(this);
    }

    public StaffStorage(StaffIterator iterator) {
        this.iterator = iterator;
    }

    public StaffIterator getIterator() {
        return iterator;
    }

    public void setIterator(StaffIterator iterator) {
        this.iterator = iterator;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
