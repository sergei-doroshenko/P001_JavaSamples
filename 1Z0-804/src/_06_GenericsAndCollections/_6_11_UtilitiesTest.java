package _06_GenericsAndCollections;

import java.util.ArrayList;
import java.util.List;

public class _6_11_UtilitiesTest {
	public static void main(String []args) {
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		System.out.println("The original list is: " + intList);
		_6_11_Utilities.fill(intList, 100);
		System.out.println("The list after calling Utilities.fill() is: " + intList);
	}
}
