package _06_GenericsAndCollections;

// This program demonstrates the usage of TreeSet class

import java.util.*;

class TreeSetTest {
	public static void main(String []args) {
		String pangram = "the quick brown fox jumps over the lazy dog"; 
		Set<Character> aToZee = new TreeSet<>();
		for(char gram : pangram.toCharArray())  
			aToZee.add(gram); 
System.out.println("The pangram is: " + pangram);
		System.out.print("Sorted pangram characters are: " + aToZee);		
	}
}
