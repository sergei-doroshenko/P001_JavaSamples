package _06_GenericsAndCollections;

// This program demonstrates generic methods
import java.util.*;

public class Utilities {
	public static <T> void fill(List<T> list, T val) {
		for(int i = 0; i < list.size(); i++) 
			list.set(i, val); 
	}
}