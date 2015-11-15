package _06_GenericsAndCollections;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Sergei on 20.10.2015.
 */
public class App01_TreeSet {
    public static void main(String []args) {
        String pangram = "the quick brown fox jumps over the lazy dog";
        Set<Character> aToZee = new TreeSet<Character>();

        for(char gram : pangram.toCharArray())
            aToZee.add(gram);

        System.out.println("The pangram is: " + pangram);
        System.out.print("Sorted pangram characters are: " + aToZee);
    }
}
