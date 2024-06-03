public class Rectangle {

	// what should these be? public? private?
	int x;
	int y;
	int x2; 
	int y2; 

	// default constructor
	public Rectangle() { 

	}

	// constructor to build a rectangle with only one coordinate pair
	public Rectangle(int newX, int newY) {
		x = newX;
		y = newY;
	}

	// constructor used to fully initialize a Rectangle
	public Rectangle(int newX, int newY, int newX2, int newY2) {
		x = newX;
		y = newY;
		x2 = newX2;
		y2 = newY2;
	}

	public void setXY(int newX, int newY) {
		x = newX;
		y = newY;
	}

	public String getXY() {
		return " " + x + " " + y;
	}

	public void printMemoryAddress() {
		System.out.println("Inside the object, I use \'this\' to gain access to memory location: " + this.toString());
	}

	// equals VS isEquals (note you could have named the functions identically (overloading))
	// 'static' methods are associated with the class itself, not an object (instance of a class)
	// do static methods then have any concept of 'this'?
	public static boolean isEquals(Rectangle one, Rectangle two) {
		boolean retVal = false; // start off not being equal

		if (one.x == two.x && one.y == two.y && one.x2 == two.x2 && one.y2 == two.y2) {
			retVal = true;
		}

		return retVal;
	}

	// we've used the built-in equals() method to compare strings. if we want to use it
	// on our own objects, we'll need to take it (inherit it) and make our own version (override it)
	// the original 'equals' method compares memory addresses to check if objects occupy the same 
	// address. However, we want to override this method to compare Rectangles based on their 
	// attributes, such as 'x', 'y', 'x2', 'y2', providing a comparison based on their values, not 
	// memory addresses. This allows for a more meaningful comparison of Rectangles for equality 
	// based on their attributes.

	@Override // this is good practice since we are using the equals method from the Object class
	public boolean equals(Object other) {
		// cast the object to its known type so we can compare their attributes
		Rectangle theOther = (Rectangle) other; // this is the same as casting, say, int to String

		if (this.x == theOther.x && this.y == theOther.y &&
				this.x2 == theOther.x2 && this.y2 == theOther.y2) {
			return true;
		}

		return false;
	}
}