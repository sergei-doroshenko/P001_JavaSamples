package _06_GenericsAndCollections.Listing_6_22;

// This program shows the usage of Deque interface

import java.util.*;

class SplQueue {
	private Deque<String> splQ = new ArrayDeque<>();
	void addInQueue(String customer){
		splQ.addLast(customer);
	}
	void removeFront(){
		splQ.removeFirst();
	}
	void removeBack(){
		splQ.removeLast();
	}
	void printQueue(){
		System.out.println("Special queue contains: " + splQ);
	}
}