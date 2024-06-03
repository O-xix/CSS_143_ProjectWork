import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //Initializing variables.      
        File file = new File("fractions.txt");

        //Using ArrayLists due to there being an unknown amount of simiplified fractions.
        ObjectList fractionCounterList = new ObjectList();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String fractionRead = scanner.nextLine();
                
                String[] fractionParts = fractionRead.split("/");
                Fraction fraction = new Fraction(Integer.parseInt(fractionParts[0]), Integer.parseInt(fractionParts[1]));

                boolean fractionCounterExisting = false;
                //Used to check if fractionCounter already exists.
                for (int i = 0; i < fractionCounterList.myObjects.length; i++) {
                   //Need to compare fractions on a decimal level:
                    if (!(fractionCounterList.myObjects[i] == null) && ((fractionCounterList.myObjects[i].fraction.numerator/fractionCounterList.myObjects[i].fraction.denominator) == (fraction.numerator/fraction.denominator))) {
                        fractionCounterExisting = true;
                        fractionCounterList.myObjects[i].counter++;
                        
                        //Need to read fraction that's already there, to achieve the simplist fraction. (We don't need to further simplify from fractions already there, as specified in the assignment.)
                        if ((fractionCounterList.myObjects[i].fraction.numerator > fraction.numerator) && (fractionCounterList.myObjects[i].fraction.denominator > fraction.denominator)) {
                           fractionCounterList.myObjects[i].fraction.setFraction(fraction.numerator, fraction.denominator);
                        }
                        
                    }
                }
                //If the fractionCounter does not exist, also this was the point where I decided I had to change the structure of the ObjectList to be made of , because it wasn't working for some reason.
                if (fractionCounterExisting == false) {
                    fractionCounterList.add(new FractionCounter(fraction));
                }
            }
            scanner.close();

            //Print out results:
            for (int i = 0; i < fractionCounterList.myObjects.length; i++) {
                if ((fractionCounterList.myObjects[i].fraction.getNumerator() == 0) && (fractionCounterList.myObjects[i].fraction.getDenominator() == 0)) {

                }
                System.out.println(fractionCounterList.myObjects[i].toString());
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


 
