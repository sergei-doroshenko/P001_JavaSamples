package _06_GenericsAndCollections;
// This program demonstrates the usage of navigable tree interface and TreeMap class

import java.util.NavigableMap;
import java.util.TreeMap;

public class _6_20_NavigableMapTest {
	public static void main(String []args) {
		NavigableMap<Integer, String> examScores = new TreeMap<>();

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

