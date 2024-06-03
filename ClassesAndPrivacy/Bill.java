public class Bill {
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
     * @param onDay
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
}
