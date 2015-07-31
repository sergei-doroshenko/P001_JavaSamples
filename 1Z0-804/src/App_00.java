import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Sergei on 31.07.2015.
 */
public class App_00 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>((o1, o2) -> { // ascending order 1,2,3.... o1 - o2
            if (o1 > o2) return 1;
            if (o1 < o2) return -1;
            return 0;
        });

        set.addAll(Arrays.asList(new Integer[]{13, 2, 40, 1, 104, 73, 5, 27}));

        System.out.println(set);
    }
}
