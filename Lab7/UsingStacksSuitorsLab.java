import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* CSSSKL 162
 * 
 * UsingStacksSuitorsLab
 * 
 * This class is mostly a driver for playing with Strings as palindromes, 
 * both iteratively and recursively.  The UsingStacksSuitorsLab class itself is
 * a runnable object, so it can be passed to a thread in our Queue demo
 * 
 * 
 */

public class UsingStacksSuitorsLab implements Runnable {
	private static int threadCount = 0;
	private String name;
	
	public UsingStacksSuitorsLab() {
		name = "#" + threadCount++ + "Thread";
	}
	
	public static void main(String[] args) {
		String s1 = "food";		    //not a palindrome
		String s2 = "racecar";      //a palindrome
			
		System.out.println("String1 is \"" + s1 + "\"");
		System.out.println("String2 is \"" + s2 + "\"");
		
		System.out.println(s1 + " reversed is: ");
		printReverse(s1);
		System.out.println(s2 + " reversed is: ");
		printReverse(s2);
		
	    recPrintReverse(s1);
		System.out.println();
		recPrintReverse(s2);
		System.out.println();

		System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
		System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));
		
		System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
		System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));	
		
		//System.out.println("Did we build a Queue of Threads and start them? " + buildThreadQueue());
		
		int n = 6;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
		
		n = 10;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
	}
		
	
	
	
	public static void printReverse(String target) {
		LLStack llstack = new LLStack();
		for (int i = 0; i < target.length(); i++) {
			llstack.addToStart(target.charAt(i));
		}
		while (!(llstack.isEmpty())) {
			System.out.print(llstack.deleteHead());
		}
		System.out.println();
	}
	
	public static void recPrintReverse(String target) {
		System.out.print(target.charAt(target.length() - 1));
		if (target.length() > 1) {
			recPrintReverse(target.substring(0, (target.length() - 1)));
		}
	}
	
	public static boolean isPalindrome(String input) {
        LLStack llstack = new LLStack();
		String reverseString = "";

		for (int i = 0; i < input.length(); i++) {
			llstack.addToStart(input.charAt(i));
		}
		while (!(llstack.isEmpty())) {
			reverseString = reverseString + llstack.deleteHead();
		}
		
		if (input.equals(reverseString)) {
			return true;
		}
		return false;
	}

	public static boolean isPalindromeRec(String sentence)	{
		if (sentence.length() <= 1) {
            return true;
        }
		if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }
		return isPalindromeRec(sentence.substring(1, sentence.length() - 1));
	}
	
	public static int findPlaceToStand(int numSuitors) {
		LLQueue llQueue = new LLQueue();

        for (int i = 1; i <= numSuitors; i++) {
            llQueue.offer(i);
        }

        while (llQueue.size() > 1) {
			Object suitor1 = llQueue.poll();
            Object suitor2 = llQueue.poll();
			if (suitor1 instanceof Integer && suitor2 instanceof Integer) {
				int suit1 = ((Integer) suitor1);
				int suit2 = ((Integer) suitor2);

				llQueue.offer(suit1);
				llQueue.offer(suit2);

				llQueue.poll();
			}
            
        }

		Object returnVal = llQueue.poll();;
		if (returnVal instanceof Integer) {
			return (Integer) returnVal;
		}
		return -1;
	}	
	/*
	public static int findPlaceToStandStack(int numSuitors) {
        LLStack suitorStack = new LLStack();

        for (int i = 1; i <= numSuitors; i++) {
            suitorStack.addToStart(i);
        }

        while (suitorStack.size() > 1) {
            int suitor1 = suitorStack.deleteHead();
            int suitor2 = suitorStack.deleteHead();
            suitorStack.addToStart(suitor1);
            suitorStack.addToStart(suitor2);

            suitorStack.deleteHead();
        }

        return suitorStack.deleteHead();
    }
*/

	public static boolean buildThreadQueue() {	//returns true upon success
		Queue<Thread> q = new LinkedList<Thread>(); 
		
		//when our program starts up, it might create multiple threads to use
		q.enqueue( new Thread(new UsingStacksSuitorsLab()));
		q.enqueue( new Thread(new UsingStacksSuitorsLab()));
		q.enqueue( new Thread(new UsingStacksSuitorsLab()));
		
		System.out.println("Initial Thread order:");
		q.toString();  
		
		//We need to iterate over our pool of threads and call start() on each one
		//Make a loop that dequeues a thread, calls start on it, and //enqueues it again
		//to do:
		//current = get a thread
		//current.start();
		//put the thread back
		
		System.out.println("Thread order after start()ing:");
		q.toString();  
		
		return true;  //on successful start
	}
	
	
	/*
	 * No need to edit anything below here, 
	 * unless you'd like to change the 
	 * behaviour of each thread in the thread pool above
	 */
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println(name + ": " + i + "th iteration");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				//do nothing here
			}
		}
	}
}
