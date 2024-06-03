public class Fraction implements Comparable {
    //4.1: Class Constraints
    /*
     * Numerators and denominators are unchangeable once set by the constructor.
       No denominator will be stored as a zero (so the code will never throw an ArithmeticException for division by zero).
       A fraction is always in reduced form (reduce in the constructor to ensure this)..
     */

    //4.2: Data Fields:
    public final int numerator;
    public final int denominator;

    //4.3 Constructor:
    /**
     * Variable constructor for a Fraction Object.
     * @param numerator integer representation of the numerator
     * @param denominator integer representation of the denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    /**
     * Copy constructor for a Fraction Object.
     * @param other Fraction Object.
     */
    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    //4.4: Methods:
    @Override
    public String toString() {
        return (numerator + "/" + denominator);
    }
    /**
     * Add to the value of this fraction Object.
     * @param that Fraction Object of another Fraction Object to add the value from.
     * @return Fraction resulting from the operation.
     */
    public Fraction add(Fraction that) {
        return new Fraction(((this.numerator * that.denominator) + (that.numerator * this.denominator)), (this.denominator * that.denominator));
    }
    /**
     * Subtract from the value of this fraction Object.
     * @param that Fraction Object of another Fraction Object value to subtract.
     * @return Fraction resulting from the operation.
     */
    public Fraction subtract(Fraction that) {
        return new Fraction(((this.numerator * that.denominator) - (that.numerator * this.denominator)), (this.denominator * that.denominator));
    }    
    /**
     * Calculates the double value of the Fraction Object.
     * @return double representation of the Fraction.
     */
    public double valueOf() {
        return (this.numerator * 1.0) / this.denominator;
    }
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Fraction))
            return false;
        Fraction that = (Fraction) other;
        if ((this.numerator == that.numerator) && (this.denominator == that.denominator)) {
            return true;
        }
        return false;
    }
    @Override
    public int compareTo(Object o) {
        if (o instanceof Fraction) {
            Fraction that = (Fraction) o;
            if (this.valueOf() > that.valueOf()) {
                return 1;
            }
            else if (this.valueOf() == that.valueOf()) {
                return 0;
            }
            return -1;
        }
        throw new Exception("Comparing objects that are not the same type Fraction.");
    }
}
