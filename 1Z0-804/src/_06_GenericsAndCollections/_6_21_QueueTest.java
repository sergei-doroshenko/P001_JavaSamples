package _06_GenericsAndCollections;
// This program shows the key characteristics of Queue interface

import java.util.LinkedList;
import java.util.Queue;

class _6_21_QueueTest {
	public static void main(String []args) {
		Queue<String> loginSequence = new LinkedList<>();
		
		loginSequence.add("Harrison"); 
		loginSequence.add("McCartney"); 
		loginSequence.add("Starr"); 
		loginSequence.add("Lennon"); 
		System.out.println("The login sequence is: " + loginSequence);
		while(!loginSequence.isEmpty())
			System.out.println("Removing " + loginSequence.remove());
	}
}
