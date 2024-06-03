import java.io.Serializable;

public class Bill implements Comparable, Cloneable, Serializable {
    //The internal paid date should be on or earlier than the due date.
    //Every Bill is owed someone, so the originator should never be empty.

    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;

    /**
     * Variable constructor for new Bill object.
     * @param amount Money amount value to new Bill object.
     * @param dueDate Date dueDate value to new Bill object.
     * @param originator String originator value to new Bill object.
     */
    public Bill(Money amount, Date dueDate, String originator) { //
        this.amount = new Money(amount);
        this.dueDate = new Date(dueDate);
        this.originator = originator;
        this.paidDate = null;
    }
    /**
     * Variable constructor for new Bill object.
     * @param amount Money amount value to new Bill object.
     * @param dueDate Date dueDate value to new Bill object.
     * @param originator String originator value to new Bill object.
     */
    public Bill(Money amount, Date dueDate, Date paidDate, String originator) { //
        this.amount = new Money(amount);
        this.dueDate = new Date(dueDate);
        this.originator = originator;
        this.paidDate = new Date(paidDate);
    }
    /**
     * Copy constructor.
     * @param toCopy Bill object to copy values from.
     */
    public Bill(Bill toCopy) { //
        this.amount = new Money(toCopy.amount);
        this.dueDate = new Date(toCopy.dueDate);
        if (toCopy.paidDate == null) {
            this.paidDate = null;
        }
        else {
            this.paidDate = new Date(toCopy.paidDate);
        }
        this.originator = new String(toCopy.originator);
    }
    /**
     * Getter method for dueDate.
     * @return Date value of the dueDate variable.
     */
    public Date getDueDate() { //
        return dueDate;
    }
    /**
     * Getter method for originator.
     * @return String value of the originator variable.
     */
    public String getOriginator() { //
        return originator;
    }
    /**
     * Checks whether the Bill (object) has been paid.
     * @return Boolean value of whether the Bill (object) has been paid or not.
     */
    public boolean isPaid() { //
        if (paidDate != null) {
            return true;
        }
        return false;
    }
    /**
     * Method to set the paidDate value, and will also end the program when dueDate is earlier than paidDate
     * @param onDay Date of payment.
     */
    public void setPaid(Date onDay) { //
        this.paidDate = new Date(onDay);
        if (dueDate.isLaterThan(onDay)) {
            System.out.println("Error occured: The date this bill was paid is past it's due date.");
            System.exit(0);
        }
    }
    /**
     * Resets the paidDate to a null value.
     */
    public void setUnpaid() { //
        this.paidDate = null;
    }
    /**
     * Setter method for the dueDate variable.
     * @param nextDate New value for the dueDate variable.
     */
    public void setDueDate(Date nextDate) { //
        this.dueDate = nextDate;
    }
    /**
     * Setter method for the amount variable.
     * @param amount New value for the amount variable.
     */
    public void setAmount(Money amount) { //
        this.amount = new Money(amount);
    }
    /**
     * Getter method for the amount variable.
     * @return Value of the amount variable.
     */
    public Money getAmount() { //
        return amount;
    }
    /**
     * Setter method for originator variable.
     * @param originator New value for originator variable.
     */
    public void setOriginator(String originator) { //
        this.originator = originator;
    }
    @Override
    public String toString() { //
        if (paidDate == null) {
            return ("Amount: " + this.amount.toString() + ", Due Date: " + this.dueDate.toString() + ", To: " + originator + ", Paid: " + this.isPaid());
        }
        return ("Amount: " + this.amount.toString() + ", Due Date: " + this.dueDate.toString() + ", To: " + originator + ", Paid: " + this.isPaid() + ", Paid on: " + paidDate.toString());
    }
    /**
     * A differently signed method with the same functionality of the equals function.
     * @param toCompare Another bill to check value equivalency.
     * @return Boolean value resulting from checking value equivalency of this Bill object and Bill toCompare. 
     */
    public boolean equals(Bill toCompare) { //
        if (this.amount.equals(toCompare.amount) && this.dueDate.equals(toCompare.dueDate) && this.paidDate.equals(toCompare.paidDate) && this.originator.equals(toCompare.originator)) {
            return true;
        }
        return false;
    }
    @Override
    /**
     * Overriden compareTo method which allows for the numerical comparision of Objects of the same kind.  
     * @param o Object which should be of type Bill to be properly compared, or an UnsupportedOperationException will be thrown. 
     * @return int which represents the comparision result of these operations. 1 is returned if this Bill is greater than Object o, -1 is returned this Bill is less than Object o, 0 is returned if this Bill is equal to Object o.
     */
    public int compareTo(Object o) {
        if (o instanceof Bill) {
            //Whatever happens, this should be the case:
            //sgn(x.compareTo(y)) == -sgn(y.compareTo(x))
            Bill that = (Bill) o;

            int returnValue = this.amount.compareTo(that.amount) + this.dueDate.compareTo(that.dueDate) + this.paidDate.compareTo(that.paidDate) + this.originator.compareTo(that.originator);
            if (returnValue < 0) {
                return -1;
            }
            else if (returnValue > 0) {
                return 1;
            }
            else {
                return 0;
            }

        }
        throw new UnsupportedOperationException("Comparing two objects of different types.");
    }
    @Override
    /**
     * Creates and returns a copy of this object.
     * @return Object representation of a replica of an instance of this class.
     */
    public Object clone() throws CloneNotSupportedException {
        return new Bill(((Money) amount.clone()), ((Date) dueDate.clone()), ((Date) paidDate.clone()), originator);
    }
}
