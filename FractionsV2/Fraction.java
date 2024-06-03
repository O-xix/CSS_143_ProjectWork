public class Fraction {
    //Data Members; used double primitives because you will only really ever see fractions represented in whole number ratios, but in comparisons will use double. 
    double numerator;
    double denominator;

    //Method Members; 
    //Overloading;
    public Fraction() {
        this.numerator = 0;
        this.denominator = 0;
    }
    /**
     * Variable double constructor taking integer, and typecasting it to a double
     * @param numerator constructing Fraction using integer numerator
     * @param denominator constructing Fraction using integer denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = (double) numerator;
        this.denominator = (double) denominator;
    }
    /**
     * Variable double constructor
     * @param numerator constructing Fraction using double numerator
     * @param denominator constructing Fraction using double denominator
     */
    public Fraction(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //Getters & Setters;
    public double getNumerator() {
        return numerator;
    }
    public double getDenominator() {
        return denominator;
    }
    /**
     * Setter method; setting the fraction to new values that also typecasts int inputs to doubles to properly use fields.
     * @param numerator value to set numerator to
     * @param denominator value to set denominator to
     */
    public void setFraction(int numerator, int denominator) {
        this.numerator = (double) numerator;
        this.denominator = (double) denominator;
    }
    /**
     * Setter method; setting the fraction to a new values.
     * @param numerator value to set numerator to
     * @param denominator value to set denominator to
     */
    public void setFraction(double numerator, double denominator) {
        this.numerator = (int) numerator;
        this.denominator = (int) denominator;
    }
}
