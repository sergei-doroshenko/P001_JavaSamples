package _06_GenericsAndCollections;

// This program demonstrates the usage of bounded wild cards

import java.util.*;

public class BoundedWildCardUse {
	public static Double sum(List<? extends Number> numList) {
		Double result = 0.0;
		for(Number num : numList) {
			result += num.doubleValue(); 
		}
		return result;
	}

	public static void main(String []args) {
		List<Integer> intList = new ArrayList<>();
		List<Double> doubleList = new ArrayList<>();
	
		for(int i = 0; i < 5; i++) { 		
			intList.add(i);
			doubleList.add((double) (i * i));
		}
		System.out.println("The intList is: " + intList); 
		System.out.println("The sum of elements in intList is: " + sum(intList));
 
		System.out.println("The doubleList is: " + doubleList); 
		System.out.println("The sum of elements in doubleList is: " + sum(doubleList));
	}
}