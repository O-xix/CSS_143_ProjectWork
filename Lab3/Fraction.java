public class Fraction {
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
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    //4.4: Methods:
    @Override
    public String toString() {
        return (numerator + "/" + denominator);
    }
    public Fraction add(Fraction that) {
        return new Fraction(((this.numerator * that.denominator) + (that.numerator * this.denominator)), (this.denominator * that.denominator));
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
}
