/* 
 * CSS 162 Assert Demo
 * 
 * Usage: This software is configured to crash your program immediately upon execution.
 * If your software doesn't crash, you don't have assertions enabled (use "-ea")
 * in your editor.  Google the name of your editor and "how to enable asserts" or follow
 * the instructions specific to BlueJ or Eclipse in the lab.
 * 
 * Author: Rob Nash
 */

import java.util.ArrayList;
import java.util.Scanner;

public class AssertDemo {

	/* Work on this in a piecewise fashion by uncommenting and focusing on one section at a time
	 * in isolation rather than running everything at once.
	 */
	public static void main(String[] args) {
		assert(true);
		/*
		 * Explain the first two asserts in main; which of the two is breaking the program? Comment out the offending assert line and rerun your code.
		 * assert(false) is doing so, because it's asserting a false case, which is a functionality to break the program when an asserted condition is false. 
		 */
		//assert(false);
		
		warmUpAsserts();
		
		assertWithPrimitives();
		
		assertWithObjects();
		
		homeworkRelatedAsserts();
	}

	/*
	 * Just a few warm-up asserts here.
	 * Add two new assert() statements after the TODO below
	 */
	private static void warmUpAsserts() {	
			assert( 5 > 1 );
			
			int a = 30;
			assert(a != 0);
	
			assert(null == null);	  //could this ever be false?
			assert(true == true);	  //a bad day indeed if this could be false
			//TODO: craft two more asserts and place them here.  If they're false, they'll crash the program.
			assert(a == 30);
			assert(false == false);
	}

	/*
	 * Using asserts in conjunction with primitive types is familiar to you;
	 * just as in a loop or if, you want to form a true/false (boolean) expression
	 * by employing the relational operators.
	 */
	private static void assertWithPrimitives() {
		//assert below to ensure a Fraction's denominator is never 0
		Scanner keys = new Scanner(System.in);
		System.out.println("Enter an integer numerator:");
		int num = keys.nextInt();
				
		System.out.println("Enter an int denominator, not 0:");
		int denom = keys.nextInt();
				
		assert(denom != 0);
	
		//assert that all ArrayLists start empty
		ArrayList<String> emptyList = new ArrayList<String>();
		assert(emptyList.size() == 0);
		//TODO: build two more asserts that use primitives and relational operators here
		assert(num <= denom);
		assert(num >= denom);
	}
	
	/*
	 * Asserts work with both primitives and objects.  Just as you 
	 * use "==" with primitives and ".equals()" with objects, so too 
	 * will you use ".equals()" in asserts that deal with object equality. 
	 */
	private static void assertWithObjects() {
		AssertDemo ad = new AssertDemo();
		ad.checkAddress(ad);		
		//guess what .equals() does if you don't create one yourself? (hint ==)
		assert(ad.equals(ad));  
		//TODO: make a few objects from any previous lab and test them with assert
		//I know I used wrapper classes, they were the easiest to test, obviously.
		String string = new String("null");
		String string1 = new String("null");

		Integer integer = new Integer(19);
		Integer integer1 = new Integer(19);
		//example: make two Point objects at the origin and assert they are equal
		//assert(p1.equals(p2);  //example
		assert(string.equals(string1));
		assert(integer.equals(integer1));
	}


	/*
	 * This function compares the address at "this" to the address of the object handed 
	 * into the function.
	 */
	public void checkAddress(Object input) {
		System.out.println("Address of this :" + this);
		//"this" will print out a address due to the Object.toString method.
		System.out.println("Address of input:" + input);
		//"input" will print out a address due to the Object.toString method.
		//how many aliases for the one "new" object created in main exist in this scope?: Just one more, the memory address.
		//1? 2? 3? Which are they?
		assert(this == input);  //== does an address check for objects, which is frequently NOT what we want
		assert(this.equals(input));
		assertWithObjects();
	}

	/*	
	 * Asserts are a useful tool for transforming postconditions and class invariants into code.
	 * Lets build a few asserts that work with your current Bill & Money assignment.
	 * Change the value of paidDate and cents to trip the asserts and observe the asserted error message. 
	 */
	private static void homeworkRelatedAsserts() {
		Object paidDate = new Object();  //really, a Date 
		assert(paidDate != null);  	 //perhaps one rule is that paidDate shouldn't be null after calling setPaidDate()
		int cents = 0;
		assert( cents >= 0 && cents <=99);  //another class invariant is written as an assert here.
		//TODO: craft 2 more asserts that you could use with any assignment
		/* Date date = new Date(month, day, year);
		 * assert(year > 0);
		 * assert(month >= 1 && month <= 12);
		 */
	}
}
