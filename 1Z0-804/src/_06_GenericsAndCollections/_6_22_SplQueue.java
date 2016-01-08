package _06_GenericsAndCollections;

// This program shows the usage of Deque interface

import java.util.ArrayDeque;
import java.util.Deque;

class _6_22_SplQueue {
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