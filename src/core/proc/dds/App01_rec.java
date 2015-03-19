package core.proc.dds;

/**
 * Created by Sergei on 24.02.2015.
 */
public class App01_rec {
    public static void main(String[] args) {

        Node n0 = generate(5);
        System.out.println(toStr(n0));
        Node n1 = copy(n0);
        System.out.println(toStr(n1));
        System.out.println(isEqLists(n1, n0));
        System.out.println("Sum = " + sum(n0));
        System.out.println("Mul = " + mul(n0));
        System.out.println("Max = " + max(n0));

        n1.next.next.value = 1000;
        System.out.println(toStr(n1));
        System.out.println(isEqLists(n1,n0));
        Node n3 = merge(n0, n1);
        System.out.println(toStr(n3));
    }

    public static String toStr(Node tail) {
        return tail == null ? "*" : tail.value + " -> " + toStr(tail.next);
    }

    public static Node generate(int length) {
        if(length < 0) {
            return null;
        }
        return new Node(length, generate(length - 1));
    }

    public static Node copy(Node tail) {
        return tail == null ? null : new Node(tail.value, copy(tail.next));
    }

    public static boolean isEqLists(Node t1, Node t2) {
        if (t1 != null && t2 != null) {
            return t1.value == t2.value && isEqLists(t1.next, t2.next);
        }
        return t1 == t2;
    }

    public static Node merge(Node t0, Node t1) {
        if (t0 != null && t1 != null) {
            if (t0.value > t1.value) {
                return new Node(t0.value, merge(t0.next, t1));
            } else {
                return new Node(t1.value, merge(t0, t1.next));
            }
        } else {
            return t0 == null ? t1 : t0;
        }
    }

    public static int sum(Node tail) {
        return (tail == null) ? 0 : tail.value + sum(tail.next);
    }

    public static int mul(Node tail) {
        return (tail == null) ? 1 : (tail.value == 0 ? 1 * mul(tail.next) : tail.value * mul(tail.next));
    }

    public static int max (Node tail) {
        return (tail == null) ? 0 : Math.max(tail.value, max(tail.next));
    }
}
