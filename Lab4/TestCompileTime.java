public class TestCompileTime {
	int[] numbers;
	public TestCompileTime() {
		numbers = new int[4];
		for (int i = 0; i < 4; i++) {
			numbers[i] = i;

		}
	}
	public static void main(String args[]) {
		TestCompileTime t = new TestCompileTime();
		if(Debug.DEBUG) {
			System.err.println("Debug is turned on");
			System.out.println("");
	        for (int i = 0; i < 4; i++) {
	            t.numbers[i] = i;
	            System.out.println("DEBUG_STATEMENT: number[" + i + "]=" + i);

	        }
  		}
  		else
  			System.out.println("Debug is turned off");
		for (int i = 0; i < 4; i++) {
			int element = t.numbers[i];
			System.out.print(element + ", ");
	    }
	    System.out.println();
 	}
}