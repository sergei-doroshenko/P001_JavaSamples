package core.proc.dds;

/**
 * Created by Sergei on 24.02.2015.
 */
public class Node {
    public int value;
    public Node next;

    public Node (int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" + value + "}";
    }

    public void display() {
        for (Node curr = this; curr != null; curr = curr.next) {
            System.out.print(curr + " -> ");
        }
        System.out.println("*");
    }
}
