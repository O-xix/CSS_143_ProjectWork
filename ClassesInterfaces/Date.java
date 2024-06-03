import java.io.Serializable;

public class Date implements Comparable, Cloneable, Serializable {
    //All days should be between [1-31]
    //All months should be between [1-12]
    //All years should be between [2001-2024]

    private int month;
    private int day;
    private int year;

    /**
     * Constructor properly initializing month, day, year variable and assigning a value to it.
     * @param month Month value to new Date object.
     * @param day Day value to new Date object.
     * @param year Year value to new Date object.
     */
    public Date(int month, int day, int year) { //
        this.day = (day % 31);
        this.month = (month % 12) + (day / 31);
        this.year = year + (month / 12);
    }

    /**
     * Copy constructor.
     * @param otherDate Date object to copy values from.
     */
    public Date(Date otherDate) { //
        this.day = otherDate.getDay();
        this.month = otherDate.getMonth();
        this.year = otherDate.getYear();
    }
    /**
     * Getter for day variable.
     * @return integer value of day
     */
    public int getDay() { //
        return day;
    }
    /**
     * Getter for month variable.
     * @return integer value of month
     */
    public int getMonth() { //
        return month;
    }
    /**
     * Getter for year variable.
     * @return integer value of year
     */
    public int getYear() { //
        return year;
    }
    /**
     * Setter method for day.
     * @param day New value of the day variable.
     */
    public void setDay(int day) { //
        this.day = (day % 31);
        this.month = (this.month % 12) + (day / 31);
    }
    /**
     * Setter method for month.
     * @param month New value of the month variable.
     */
    public void setMonth(int month) { //
        this.month = (month % 12) + (day / 31);
        this.year = year + (month / 12);
    }
    /**
     * Setter method for year.
     * @param year New value of the year variable.
     */
    public void setYear(int year) { //
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) { //
        if (obj instanceof Date) {
            Date date = (Date) obj;
            if (this.month == date.getMonth() && this.day == date.getDay() && this.year == date.getYear()) {
                return true;
            }
        }
        return false;
    }
    /**
     * Just for me to put this coding block somewhere else. Used to check the dueDate invariance.
     * @param earlierDate A date should be earlier for this to be true.
     * @return Boolean value of whether earlierDate is actually earlier than this Date.
     */
    public boolean isLaterThan(Date earlierDate) { //
        if (this.year > earlierDate.year) {
            return true;
        } else if (this.year == earlierDate.year && this.month > earlierDate.month) {
            return true;
        } else if (this.year == earlierDate.year && this.month == earlierDate.month && this.day > earlierDate.day) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() { //
        return (month + "/" + day + "/" + year);
    }

    @Override
    /**
     * Overriden compareTo method which allows for the numerical comparision of Objects of the same kind.  
     * @param o Object which should be of type Date to be properly compared, or an UnsupportedOperationException will be thrown. 
     * @return int which represents the comparision result of these operations. 1 is returned if this Date is greater than Object o, -1 is returned this Date is less than Object o, 0 is returned if this Date is equal to Object o.
     */
    public int compareTo(Object o) {
        if (o instanceof Date) {
            //Whatever happens, this should be the case:
            //sgn(x.compareTo(y)) == -sgn(y.compareTo(x))
            Date that = (Date) o;

            int returnValue = ((Integer.valueOf(this.month)).compareTo(Integer.valueOf(that.month)) * (365/12)) + (Integer.valueOf(this.day)).compareTo(Integer.valueOf(that.day)) + ((Integer.valueOf(this.year)).compareTo(Integer.valueOf(that.year)) * 365);
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
    /**
     * Creates and returns a copy of this object.
     * @return Object representation of a replica of an instance of this class.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Date(month, day, year);
    }
}
