package _04_AdvancedClassDesign;

public class _4_4_Counter {
	private static int count; 
	static {
		// code in this static block will be executed when JVM loads the class into memory 
		count = 1; 
	}
	public _4_4_Counter() {
		count++;
	}

	public static void printCount() { 
		System.out.println("Number of instances created so far is: " + count);
	}

	public static void main(String []args) {
		_4_4_Counter anInstance = new _4_4_Counter();
		_4_4_Counter.printCount();
		_4_4_Counter anotherInstance = new _4_4_Counter();
		_4_4_Counter.printCount();
	}
}
