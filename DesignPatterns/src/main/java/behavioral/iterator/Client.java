package behavioral.iterator;

/**
 * Created by Sergei on 08.09.2015.
 */
public class Client {
    public static void main(String[] args) {
        StaffStorage storage = new StaffStorage();
        ForwardStaffIterator iterator = (ForwardStaffIterator) storage.getIterator();
    }
}
