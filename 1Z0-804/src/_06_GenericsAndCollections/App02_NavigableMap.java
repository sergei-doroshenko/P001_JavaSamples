package _06_GenericsAndCollections;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by Sergei on 20.10.2015.
 */
public class App02_NavigableMap {
    public static void main(String []args) {
        NavigableMap<Integer, String> examScores = new TreeMap<Integer, String>();

        examScores.put(90, "Sophia");
        examScores.put(20, "Isabella");
        examScores.put(10, "Emma");
        examScores.put(50, "Olivea");

        System.out.println("The data in the map is: " + examScores);
        System.out.println("The data descending order is: " + examScores.descendingMap());
        System.out.println("Details of those who passed the exam: " + examScores.tailMap(40));
        System.out.println("The lowest mark is: " + examScores.firstEntry());
    }
}
