package _06_GenericsAndCollections;

class _6_22_SplQueueTest {
	public static void main(String []args) {
		_6_22_SplQueue splQ = new _6_22_SplQueue();
		splQ.addInQueue("Harrison");
		splQ.addInQueue("McCartney");
		splQ.addInQueue("Starr");
		splQ.addInQueue("Lennon");
		
		splQ.printQueue();
		splQ.removeFront();
		splQ.removeBack();
		splQ.printQueue();
	}
}