package _06_GenericsAndCollections.set;

import java.util.*;

/**
 * Created by Sergei_Doroshenko on 5/11/2016.
 */
public class App00_LinkedHashSet {
    public static void main(String[] args) {
        List<String> input = Arrays.asList(
                "helloween",
                "good have no doubt",
                "Where can I find my car?",
                "comon",
                "apple",
                "batman vs. superman"
        );

        Set<String> s0 = new HashSet<>();
        Set<String> s1 = new LinkedHashSet<>();

       /* for (String s : input) {
            s0.add(s);
            s1.add(s);
        }*/

        s0.addAll(input);
        s1.addAll(input);

        System.out.println(s0); // [apple, Where can I find my car?, comon, helloween, good have no doubt, batman vs. superman]
        System.out.println(s1); // [helloween, good have no doubt, Where can I find my car?, comon, apple, batman vs. superman]

        System.out.println(new ArrayList<>(s0)); // [apple, Where can I find my car?, comon, helloween, good have no doubt, batman vs. superman]
        System.out.println(new ArrayList<>(s1)); // [helloween, good have no doubt, Where can I find my car?, comon, apple, batman vs. superman]

        System.out.println(new ArrayList<>(s1).equals(input)); // true
    }
}
