package behavioral.iterator;

/**
 * Created by Sergei on 08.09.2015.
 */
public class Client {
    public static void main(String[] args) {
        StaffStorage storage = new StaffStorage();

        StaffStorage.Iterator forwardIterator = storage.getIterator(StaffStorage.IteratorType.FORWARD);

        for (int i = 0; i < 20; i++) System.out.println(forwardIterator.next());

        StaffStorage.Iterator reverseIterator = storage.getIterator(StaffStorage.IteratorType.REVERSE);

        for (int i = 0; i < 20; i++) System.out.println(reverseIterator.next());
    }
}
