package _06_GenericsAndCollections.Listing_6_19;

import java.util.*;

public class TestCircle {
	public static void main(String []args) {
		Set<Circle> circleList = new HashSet<>();
		circleList.add(new Circle(10, 20, 5)); 
		System.out.println(circleList.contains(new Circle(10, 20, 5)));
	}
}