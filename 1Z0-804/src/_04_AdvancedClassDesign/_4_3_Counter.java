package _04_AdvancedClassDesign;

// Counter class should count the number of instances created from that class 
public class _4_3_Counter {
	private static int count; // variable to store the number of objects created 
	// for every Counter object created, the default constructor will be called; 
	// so, update the counter value inside the default constructor
	public _4_3_Counter() {
		count++;
	}

	public static void printCount() { // method to print the counter value so far 
		System.out.println("Number of instances created so far is: " + count);
	}

	public static void main(String []args) {
		_4_3_Counter anInstance = new _4_3_Counter();
		// note how we call printCount using the class name instead of instance variable name 
		_4_3_Counter.printCount();
		_4_3_Counter anotherInstance = new _4_3_Counter();
		_4_3_Counter.printCount();
	}
}
