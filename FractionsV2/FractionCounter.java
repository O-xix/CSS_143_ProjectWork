public class FractionCounter {
    //Data Members;
    Fraction fraction;
    int counter;

    //Method Members;
    /**
     * FractionCounter acts as a integer counter for uniquely ratioed fractions.
     * @param theFraction represents the uniquely ratioed fraction being passed and counted as another iteration to.
     */
    public FractionCounter(Fraction theFraction) {
        this.fraction = theFraction;
        this.counter = 1;
    }
    /**
     * Unfortunately, this is unused because I kind of forgot it existed. 
     * compareAndIncrement is intended to compare two Fractions, 
     * but the reason this does not work is because it doesn't compare their values due to there not being an @Override equals() that properly compares their decimal values.
     * I cannot remember why, but that's how it is. I also don't mind, because it messes with the Driver's (the Main classes) logic
     * @param newFraction This is a Fraction object being compared to the Fraction fraction object stored in an object of FractionCounter class.
     * @return It is a boolean return due to making an easy return to determine state.
     */
    public boolean compareAndIncrement(Fraction newFraction) {
        if (this.fraction.equals(newFraction)) {
            counter++;
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return (((int) fraction.getNumerator()) + "/" + ((int) fraction.getDenominator()) + " has a count of " + counter);
    }
}
