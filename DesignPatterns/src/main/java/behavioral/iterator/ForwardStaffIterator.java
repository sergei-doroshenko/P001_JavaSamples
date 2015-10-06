package behavioral.iterator;

/**
 * Created by Sergei on 08.09.2015.
 */
public class ForwardStaffIterator {
    private StaffStorage storage;
    private int position;

    public ForwardStaffIterator() {
    }

    public ForwardStaffIterator(StaffStorage storage) {
        this.storage = storage;
        this.position = 0;
    }

    public StaffStorage getStorage() {
        return storage;
    }

    public void setStorage(StaffStorage storage) {
        this.storage = storage;
    }

    public String next() {
        String result = storage.getList().get(position);
        if ( ++position == storage.getList().size() ) position = 0;
        return result;
    }
}
