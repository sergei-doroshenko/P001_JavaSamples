package _06_GenericsAndCollections;

// It demonstrates sorting on Arrays
import java.util.*;

public class CollectionsTest {
	public static void  main(String []args) {
		String [] strArr = { "21", "1", "111", "12", "123" };
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
 
		int [] intArr = { 21, 1, 111, 12, 123 }; 
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
	}
}
 
