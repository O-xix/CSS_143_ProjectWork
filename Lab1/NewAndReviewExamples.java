import java.util.ArrayList;

/*
 * NewAndReviewExamples.java
 * Depends on Rectangle.java
 */
public class NewAndReviewExamples {

	// Modify the code below to select the case and topic you'd like to work with
	public static void main(String[] args) {
		int i = 1; // this is the "selector" for the switch statement below

		switch (i) {
			case 1:
				thisExample(); // testing 'this'
				System.out.println("But how come in main there is no \'this\'?");
				// see the isEquals function for more proof that static methods have no object
				// target
				break;
			case 2: // testing toString() method
				arrayListExample();
			case 3: // testing equals() method
				equalsVSisEquals(); // this also demonstrates static vs nonstatic methods
				break;
			case 4: // testing pass-by-value
				System.out.println("primitive (in main) before function call: " + i);
				byValueExample(i);
				System.out.println("primitive (in main) after function call: " + i);
				break;
			case 5: // testing pass-by-reference
				Rectangle watchMe = new Rectangle(1, 1, 1, 1);
				System.out.println("watchMe's X,Y: " + watchMe.getXY());
				byReferenceExample(watchMe);
				System.out.println("watchMe's X,Y: " + watchMe.getXY());
				break;
			default:
				arrayListExample();
				// break;
		}
	}

	public static void thisExample() {
		Rectangle myRect = new Rectangle(1, 3, 9, 9);

		// getting the address directly
		System.out.println("myRect lives at address: " + myRect);

		// getting the address from the Rectangle method
		myRect.printMemoryAddress();

	}

	private static void equalsVSisEquals() {
		Rectangle rect1 = new Rectangle(1, 1, 5, 5);
		Rectangle rect2 = new Rectangle(1, 1, 5, 5);
		Rectangle rect3 = new Rectangle(2, 3, 4, 5);

		// first, test using the static isEquals method
		System.out.println("Are rect1 and rect2 equal? " + Rectangle.isEquals(rect1, rect2));
		System.out.println("Are rect2 and rect3 equal? " + Rectangle.isEquals(rect2, rect3));

		// now testing with the equals method
		System.out.println("Are rect1 and rect2 equal? " + rect1.equals(rect2));
		System.out.println("Are rect2 and rect3 equal? " + rect2.equals(rect3));
	}

	private static void byValueExample(int i) {
		i = -1;
		System.out.println("i in byValueExample is now: " + i);
	}

	private static void byReferenceExample(Rectangle watchMe) {
		watchMe.setXY(5, 6);
	}

	public static void arrayListExample() { 
		ArrayList<String> myStrings = new ArrayList<String>();

		myStrings.add("Foo");
		myStrings.add("Boo");
		myStrings.add("Ethics");

		System.out.println("Size is " + myStrings.size());

		System.out.println("Elements are " + myStrings);
		System.out.println("And toString yields " + myStrings.toString());

		for (int counter = 0; counter < myStrings.size(); counter++) {
			System.out.println("Item at index:" + counter + " is " + myStrings.get(counter));
		}
	}
}