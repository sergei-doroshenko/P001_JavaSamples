package core.proc.rec.hanoi;

import java.util.Stack;

/**
 * Created by Sergei on 23.02.2015.
 */
public class HanoiTowers {
    private Stack<Integer> from = new Stack<>();
    private Stack<Integer> help = new Stack<>();
    private Stack<Integer> to = new Stack<>();

    public HanoiTowers(int[] arr) {
        for (int i = arr.length -1; i > -1; i--) {
            from.push(arr[i]);
        }
    }

    public void build() {
        exchenge(from, help, to, from.size());

    }

    public void exchenge(Stack<Integer> from, Stack<Integer> help, Stack<Integer> to, int count) {
        if (count > 0) {
            exchenge(from, to, help, count - 1);
            display();
            int biggest = from.pop();
            to.push(biggest);
            exchenge(help, from, to, count - 1);
            display();
        }

    }

    public void display () {
        System.out.println("----------");
        System.out.println(from);
        System.out.println(help);
        System.out.println(to);
        System.out.println("----------");
    }

}
