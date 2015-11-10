package _06_GenericsAndCollections;

// This program demonstrates the usage of arrays as list

import java.util.*; 

public class ArrayAsList2{
	public static void main(String []args) {
		Double [] temperatureArray = {31.1, 30.0, 32.5, 34.9, 33.7, 27.8};
		System.out.println("The original array is:     " + Arrays.toString(temperatureArray));
		List<Double> temperatureList = new ArrayList<>(Arrays.asList(temperatureArray));
		temperatureList.add(32.3);
		System.out.println("The new List with an added element is: " + temperatureList);
	}
}