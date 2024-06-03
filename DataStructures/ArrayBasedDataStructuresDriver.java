/*
 *  Incomplete Driver for ArrayList(ObjectList), Stack and Queue
 * I've made Possible standard-use cases and invariance cases, like ArrayList.indexOf() returning -1. 
 * Possible edge-cases that can be implemented, though I'd rather leave it here, would include null Pointers, Objects of different types as parameters, etc.
 */

public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
		System.out.println("Stack Tests: \n");
		stackTests();
		System.out.println("Queue Tests: \n");
		queueTests();
		System.out.println("ArrayList Tests: \n");
		arrayListTests();
	}

	/**
	 * Pre: 
	 * 	- No prior precondition necessary.
	 * 
	 * Post:
	 * 	- Entirely for the purpose of testing the ArrayList data structure.
	 */
	private static void arrayListTests() {
		//todo: make more tests here
		ArrayList a = new ArrayList();

		//test 1: true positive		
		a.insert('B', 0);
		System.out.println("a size: " + a.size());
		a.add('d');
		a.insert('a',0);
		System.out.println("a in a at: " + a.indexOf('a'));
		a.insert('t',1);
		System.out.println("a size: " + a.size());
		System.out.println(a.get(0));
		System.out.println("f in a at: " + a.indexOf('f'));

		System.out.println(a.toString());

		//test 2: equals
		ArrayList b = new ArrayList(a);
		System.out.println(a.equals(b));
		
		while(a.isEmpty() == false) {
			System.out.println(a.remove(0));
			System.out.println("a size: " + a.size());
		}
	}

	/**
	 * Pre: 
	 * 	- No prior precondition necessary.
	 * 
	 * Post:
	 * 	- Entirely for the purpose of testing the ArrayList data structure.
	 */
	private static void queueTests() {
		//todo: make more tests here
		Queue a = new Queue();
		
		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');
		
		System.out.println(a.toString());

		//test 2: equals
		Queue b = new Queue(a);
		System.out.println(a.equals(b));
		
		while(a.isEmpty() == false) {
			System.out.println(a.dequeue());
			System.out.println("a: " + a.size());
		}

	}

	/**
	 * Pre: 
	 * 	- No prior precondition necessary.
	 * 
	 * Post:
	 * 	- Entirely for the purpose of testing the ArrayList data structure.
	 */
	private static void stackTests() {
		//todo: make more tests here
		Stack a = new Stack();
		
		a.push('B');
		a.push('a');
		a.push('t');
		
		System.out.println(a.toString());

		//test 2: equals
		Stack b = new Stack(a);
		System.out.println(a.equals(b));

		
		while(a.isEmpty() == false) {
			System.out.println(a.pop());
			System.out.println("a: " + a.size());
		}
	}
	

}
