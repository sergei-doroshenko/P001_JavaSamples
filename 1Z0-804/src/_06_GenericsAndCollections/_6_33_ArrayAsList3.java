package _06_GenericsAndCollections;

import java.util.Arrays;
import java.util.List;

class _6_33_ArrayAsList3 {
	public static void main(String []args) {
    	Double [] temperatureArray = {31.1, 30.0, 32.5, 34.9, 33.7, 27.8};
		System.out.println("The original array is: " + Arrays.toString(temperatureArray));
    	List<Double> temperatureList = Arrays.asList(temperatureArray);
    	temperatureList.set(0, 35.2);
		System.out.println("The modified array is: " + Arrays.toString(temperatureArray));
	}
}