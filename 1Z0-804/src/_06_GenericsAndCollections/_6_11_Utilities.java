package _06_GenericsAndCollections;

// This program demonstrates generic methods

import java.util.List;

public class _6_11_Utilities {
	public static <T> void fill(List<T> list, T val) {
		for(int i = 0; i < list.size(); i++) 
			list.set(i, val); 
	}
}