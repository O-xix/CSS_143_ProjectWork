/*
 * 1. I didn't use arrays, but I did use a collection in the form of ArrayLists, which no, you can't use without. 
 * The assumption is that the test cases may be of differing size and length, so unless you can create an ambiguous amount of individual unique variables and call each one of them and traverse them, then no.
 * That said, the least number of fraction-related variables you can use to solve this problem is between 9 and 14. The reason I say that is that I'm not entirely aware of other approaches to this problem, but at least the first nine variables I ever initilized in the program are neccessary.
 * 2. Again, I did not use an array, but if you were to make each fraction an object, encapsulate their occurances, decimal, and fraction values, it's possible to create an ArrayList of them.
 * Other instances of arrays in my program can be easily substituted, like when I was splitting fractions.
 * 3. I'm not sure if I entirely understand what this question is asking, 
 * but it's possible to make sub-classes within a class to make it act as a normal class, though typically for less manupulable objects. Not so sure of the "other data types" and "composition".
 * 4. While lengthy, there is converting it to a decimal and comparing those values. GCD then can be used to format. For example, the way I wrote the program does not make any 
 * unique fractions, so it results in printed output lines, such as "80/90 has a count of 2" and "15/25 has a count of 1", which aren't simplifed. So using GCD to simplify them would work, or at least make it look neater.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FractionsV1 {
    public static void main(String[] args) {
        //Initializing variables.      
        File file = new File("fractions.txt");
        int numerator;
        int denominator;
        double decimal;

        //Using ArrayLists due to there being an unknown amount of simiplified fractions.
        ArrayList<Integer> occurances = new ArrayList<Integer>();
        ArrayList<Double> decimals = new ArrayList<Double>();
        ArrayList<String> fractions = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String fractionRead = scanner.nextLine();
                
                //If parseInt not expected or not viable, is possible to read individual characters in a for loop, multiply what already exists in the variable by 10 and add the next digit each iteration.
                String[] fractionParts = fractionRead.split("/");
                numerator = Integer.parseInt(fractionParts[0]);
                denominator = Integer.parseInt(fractionParts[1]);

                decimal = (numerator * 1.0)/(denominator * 1.0);
                boolean checkDecimal = false;
                //Used to check if decimal already exists.
                for (int i = 0; i < decimals.size(); i++) {
                    if (decimals.get(i) == decimal) {
                        checkDecimal = true;
                        occurances.set(i, occurances.get(i) + 1);
                        
                        //Need to read fraction that's already there, to achieve the simplist fraction. (We don't need to further simplify from fractions already there, as specified in the assignment.)
                        String[] existingFractionParts = fractions.get(i).split("/");
                        int existingNumerator = Integer.parseInt(existingFractionParts[0]);
                        int existingDenominator = Integer.parseInt(existingFractionParts[1]);
                        if (numerator < existingNumerator && denominator < existingDenominator) {
                            fractions.set(i, fractionRead);
                        }
                    }
                }
                //If the decimal does not exist.
                if (checkDecimal == false) {
                    decimals.add(decimal);
                    fractions.add(numerator + "/" + denominator);
                    occurances.add(1);
                }
            }
            scanner.close();

            //Print out results:
            for (int i = 0; i < fractions.size(); i++) {
                System.out.println(fractions.get(i) + " has a count of " + occurances.get(i));
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
