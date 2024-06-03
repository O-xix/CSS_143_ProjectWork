public class Money {
    //Our internal cents should be between [0-99] at all times
    //Our internal Cents and Dollars should never be < 0, at all times

    private int dollars;
    private int cents;

    /**
     * Constructor properly initializing dollars variable and assigning a value to it.
     * @param dol Dollar value to new Money object.
     */
    public Money(int dol) { //
        this.dollars = dol;
        this.cents = 0;
    }
    /**
     * Constructor properly initializing dollars, cents variable and assigning a value to it.
     * @param dol Dollar value to new Money object.
     * @param cent Cent value to new Money object.
     */
    public Money(int dol, int cent) { //
        this.dollars = dol + (cent / 100);
        this.cents = (cent % 100);
    }
    /**
     * Copy constructor.
     * @param other Money object to copy values from.
     */
    public Money(Money other) { //
        this(other.dollars, other.cents);
    }

    //Getters and setters.
    /**
     * Getter method for Dollars.
     * @return Value of the Dollars variable.
     */
    public int getDollars() { //
        return dollars;
    }
    /**
     * Getter method for Cents.
     * @return Value of the Cents variable.
     */
    public int getCents() { //
        return cents;
    }
    /**
     * Setter method for Dollars.
     * @param dollars New value of the Dollars variable.
     */
    public void setDollars(int dollars) { //
        this.dollars = dollars;
    }
    /**
     * Setter method for Dollars.
     * @param cents New value of the Cents variable.
     */
    public void setCents(int cents) { //
        this.dollars += (cents / 100);
        this.cents += (cents % 100);
    }
    /**
     * Getter method for value of the object.
     * @return Overall value of the Money object.
     */
    public double getMoney() { //
        return ((dollars * 1.00) + (cents * 0.01));
    }
    /**
     * Setter method for both instance variables.
     * @param dol New value of the Dollars variable.
     * @param cent New value of the Cents variable.
     */
    public void setMoney(int dol, int cent) { //
        this.dollars = dol + (cent / 100);
        this.cents = (cent % 100);
    }
    /**
     * Method to add value to dollars variables.
     * @param dol Value to add to dollars value.
     */
    public void add(int dol) { //
        this.dollars += dol;
    }
    /**
     * Method to add overall value.
     * @param dol Value to add to dollars value.
     * @param cents Value to add to cents value.
     */
    public void add(int dol, int cents) { //
        this.dollars = dol + (cents / 100);
        this.cents = (cents % 100);
    }
    /**
     * Method to add the value of other Money object.
     * @param other Other Money object.
     */
    public void add(Money other) { //
        this.dollars += other.getDollars();
        this.cents += other.getCents();
    }
    //It's not auto-suggesting JavaDoc comments here, so just for myself, I'll leave it alone.
    @Override
    public boolean equals(Object o) { //
        if (o instanceof Money) {
            Money money = (Money) o;
            if (this.dollars == money.getDollars() && this.cents == money.getCents()) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() { //
        return ("$" + dollars + "." + cents);
    }
}