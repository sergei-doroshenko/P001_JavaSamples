package core._0_proc.dds;

/**
 * Created by Sergei on 24.02.2015.
 */
public class App00 {
    public static void main (String[] args) {
        Node tail = $(3, $(2, $(1, $(0, null))));
        tail.display();
        Node list = list(3);
        list.display();
        Node l2 = _(1, 2, 3, 4);
        l2.display();


        Node t1 = new Node(5, null);
        Node t2 = new Node(4, t1);
        Node t3 = new Node(3, t2);
        Node t4 = new Node(2, t3);
        Node t5 = new Node(1, t4);
        //t1.next = t5;
        //t5.display();
        System.out.println(loopExist(t1));

    }

    public static Node $(int value, Node next) {
        return new Node(value, next);
    }

    public static Node list(int count) {
        Node tail = null;
        for (int i = 0; i < count; i++) {
            tail = new Node(i, tail);
        }
        return tail;
    }

    public static Node _(int... args){
        Node tail = null;
        for (int i = 0; i < args.length; i++) {
            tail = new Node(args[i], tail);
        }
        return tail;
    }

    /**
     * Check if exists loop in the linked list
     * @param tail - ref to linked list tail
     * @return - true if loop exists
     */
    public static boolean loopExist(Node tail) {
        Node x = tail;
        Node y = tail.next;
        while (true) {
            if (x == y) return true;
            x = x.next;
            if (y == null || y.next == null) {
                return false;
            }
            y = y.next.next;
        }
    }
}
