package behavioral.iterator;

/**
 * Created by Sergei on 08.09.2015.
 */
public class ReverseStaffIterator {
    private StaffStorage storage;
    private int position;

    public ReverseStaffIterator() {
    }

    public ReverseStaffIterator(StaffStorage storage) {
        this.storage = storage;
        this.position = 0;
    }

    public StaffStorage getStorage() {
        return storage;
    }

    public void setStorage(StaffStorage storage) {
        this.storage = storage;
    }
}
