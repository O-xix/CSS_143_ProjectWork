/*-----------------------------------------------------------------------------------
 *
 *	sum( n ) is a summation algorithm defined as follows:
 *
 *	(1)		sum( n ) =  n + (n-1) + (n-2) + ... + 1
 * 	(1a) 	sum( 1 ) = 1
 *
 * and from this definition, we can rewrite this formula in terms of itself, such that:
 *
 *	(2)	    sum( n ) = n + sum( n - 1 )
 *
 * and we can do this again
 *
 *	(3)    	sum( n ) = n + ( n - 1) + sum( n - 2 )
 *
 * and so on, and so forth, we finally end up with the same as above
 *
 *	(1)	    sum( n ) = n + (n-1) + (n-2) + ... + 1
 *
 *----------------------------------------------------------------------------------- */

import java.awt.Dimension;

import javax.swing.*;

public class RecursionLab {
    private static JTextArea myArea = new JTextArea();
    private static int count = 0;

    public static void main(String args[]) { // invoke the recursive method here...
        /**
         * TODO: switch between the two commented lines below and execute this code,
         * observing the output for both the iterative solution and the recursive solution.
         * To watch the recursive behaviour in action, set a breakpoint on the if statement
         * inside the recursiveSum() function
         *
         */
        int solution = iterativeSum(20);
        //int solution = recursiveSum( 20 );


        // Some GUI details
        myArea.setText(("Result is : " + solution + "\n" + myArea.getText()));
        JScrollPane myPane = new JScrollPane(myArea);
        myPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        myPane.setPreferredSize(new Dimension(600, 300));
        JOptionPane.showMessageDialog(null, myPane);

        // good form to include an exit call when GUIing in Java
        //System.exit(0);


        //1.2 Write at least 2 tests in main or in a separate driver code.
        System.out.println(recursiveFactorial(6));
        System.out.println(recursiveFactorial(12));

        //2.2 Write at least 2 tests to ensure that it works properly.
        System.out.println(recursivePowerOne(6, 6));
        System.out.println(recursivePowerOne(6, 8));

        //2.4 Write at least 2 tests to ensure that this second method works properly.
        System.out.println(recursivePowerTwo(6, 6));
        System.out.println(recursivePowerTwo(6, 8));

        //3.2 Write at least 2 tests to ensure that it works properly.
        System.out.println(recursiveFibonacciOne(6));
        System.out.println(recursiveFibonacciOne(8));

        //4.1 Write your tests. Think of a couple scenarios and what the solutions should be. For example, if the lottery requires you to pick 5 numbers (r = 5) between 1-70 (n = 70), how many possible combinations are there? This is one example, now write your own tests.
        System.out.println(combinationCalculation(5, 70));
        System.out.println(combinationCalculation(5, 120));

        
    }

    /**
     * Recursion is similar to iterative looping, but we
     * use method calls to repeat computations (or decompose the problem)
     * instead of explicit looping control structures.
     */
    public static int recursiveSum(int n) {
        updateRecursiveDisplay(n); // overhead for nice output, not required
        if (n == 1)                // if we're at the base case...
            return 1;              // then return the answer to the simplest problem which we know how to solve
        else                       // otherwise, we rely on the fact that sum( n ) = n + sum( n - 1 ) and keep recursing
            return (n + recursiveSum(n - 1));

        // for this method to terminate, we must be breaking the problem down into smaller
        // and smaller problems, until we reach the simplest form of the problem which we know
        // how to solve (in this case, it's the fact that sum( 1 ) == 1 )
    }

    //

    /**
     * The iterative counterpart to the above recursion. Notice how it's longer?
     * At times, an iterative solution may require more code than the recursive counterpart,
     * but, the recursive solution is slower and more memory intensive. We can always
     * recast recursion as iteration.
     */
    public static int iterativeSum(int i) {
        int total = 0;

        for (int n = i; n >= 1; n--) {
            updateIterativeDisplay(n);
            total = total + n;
        }
        return total;
    }

    public static void updateIterativeDisplay(int n) {
        count++;
        String text = myArea.getText();

        text += "\n/*******************Loop iteration " + count + "**************************************";
        text += "\n Calling iterativeSum( int n = " + n + " ). Total += " + n;
        text += "\n***************************************************************************/";

        myArea.setText(text);
    }

    // ignore this method unless interested in the output string
    public static void updateRecursiveDisplay(int n) {
        count++;
        String text = myArea.getText();

        if (count == 1) {
            text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
            text += "       CALL STACK IN MAIN MEMORY                ";
        }

        text += "\n/*******************Method invocation " + count + "*********************";

        text += "\n Calling recursiveSum( int n = " + n + " ). ";
        text += "\n The return statement from this function will resolve in " + (n - 1) + " more recursive method calls...";

        if (n != 1) {
            text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( " + (n - 1) + " ));";
        } else {
            text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
            text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
            text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
        }
        text += "\n***************************************************************************/";

        myArea.setText(text);
    }

    //1. From Summation to Factorial.
    public static int recursiveFactorial(int n) {
        if (n == 1) {
            return 1; // for summation, factorials, exponent, and Fibonacci, this is 1
        } else {
            int result = recursiveFactorial(n - 1) * n; // typically the recursive call decrements by 1 or n/2
            return result;
        }
    }

    //2.1 Build the first "brute-force" method that recursively calculates x to the power of n. Use the pseudocode provided.
    public static int recursivePowerOne(int n, int power) {
        if (power == 0) {
            return 1;
        }
        else if (power > 0) {
            return recursivePowerOne(n, power - 1) * n;
        }
        else {
            return -1;
        }
    }

    //2.3 Build the optimized method that recursively calculates x to the power of n. Use the pseudocode provided.
    public static int recursivePowerTwo(int n, int power) {
        if (power == 0) {
            return 1;
        } else if (power % 2 == 0) {
            int temp = recursivePowerTwo(n, power / 2);
            return temp * temp;
        } else {
            int temp = recursivePowerTwo(n, (power - 1) / 2);
            return n * temp * temp;
        }
    }

    //2.5 Compare the time taken by each method. Record in comments which was faster.
    /*
     * Not entirely sure, but I'm assuming recursivePowerTwo. I could check runtime, but not sure I remember how to. 
     */
    
    //3.1 Use the provided description to write a method that calculates the Fibonacci sequence of a given number.
    public static int recursiveFibonacciOne(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n > 1) {
            return recursiveFibonacciOne(n - 1) + recursiveFibonacciOne(n - 2);
        }
        else {
            return -1;
        }
    }    

    //4.2 Write a method to calculate the number of combinations using the equation posted above.
    public static int combinationCalculation(int n, int r) {
        return ((recursiveFactorial(n))/((recursiveFactorial(r))*(recursiveFactorial(n - r))));
    }
}
