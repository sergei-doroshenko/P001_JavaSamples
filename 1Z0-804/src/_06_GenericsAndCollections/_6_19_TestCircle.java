package _06_GenericsAndCollections;

import java.util.HashSet;
import java.util.Set;

public class _6_19_TestCircle {
	public static void main(String []args) {
		Set<_6_19_Circle> circleList = new HashSet<>();
		circleList.add(new _6_19_Circle(10, 20, 5));
		System.out.println(circleList.contains(new _6_19_Circle(10, 20, 5)));
	}
}