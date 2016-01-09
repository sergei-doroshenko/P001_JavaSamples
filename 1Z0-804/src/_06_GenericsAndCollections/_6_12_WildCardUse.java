package _06_GenericsAndCollections;

import java.util.ArrayList;
import java.util.List;
// This program demonstrates the usage of wild card parameters
class _6_12_WildCardUse {
	static void printList(List<?> list){
		for(Object l:list)
			System.out.println("[" + l + "]");
	}

	public static void main(String []args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(100);
		printList(list);
		List<String> strList = new ArrayList<>();
		strList.add("10");
		strList.add("100");
		printList(strList);
	}
}