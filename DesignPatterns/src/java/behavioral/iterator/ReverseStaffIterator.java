package behavioral.iterator;

/**
 * Created by Sergei on 08.09.2015.
 */
public class ReverseStaffIterator implements StaffStorage.Iterator {
    private StaffStorage storage;
    private int position;

    public ReverseStaffIterator() {
    }

    public ReverseStaffIterator(StaffStorage storage) {
        if (storage == null) {
            throw new IllegalStateException("Staff storage can't be null");
        }
        this.storage = storage;
        this.position = storage.getList().size() - 1;
    }

    public StaffStorage getStorage() {
        return storage;
    }

    public void setStorage(StaffStorage storage) {
        this.storage = storage;
    }

    @Override
    public String next() {
        String result = storage.getList().get(position);
        if ( --position < 0 ) position = storage.getList().size() - 1;
        return result;
    }
}
