package _06_GenericsAndCollections;

// This program demonstrates the usage of HashSet class 

import java.util.*;

public class RemoveDuplicates {
	public static void main(String []args) {
		String tongueTwister = "I feel, a feel, a funny feel, a funny feel I feel, if you feel the feel  I feel, I feel the feel you feel";
		Set<String> words = new HashSet<>();

		// split the sentence into words and try putting them in the set 
		Collections.addAll(words, tongueTwister.split("\\W+"));
 
		System.out.println("The tongue twister is: " + tongueTwister);
  		System.out.print("The words used were: "); 
		System.out.println(words);
	}       
}