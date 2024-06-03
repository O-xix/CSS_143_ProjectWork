public class Date {
    /*
     * What does it mean to be a date?
        What data items (called “state”) do you need to keep track of?
        Alternatively, what does a date have? (“has a” == composition)

        Dates have a month (int/String), day, and year.

       What can a date do?
        What are the actions and verbs that can be applied to a date?
        Come up with one or two. These become the class’s methods.

        They can have getters and setters, as well as advance the date and go back, and it doesn't have to be the date; just a period of time.
     */

    int month;
    int day;
    int year;

    public void setDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public void report() {
        System.out.println(month + "/" + day + "/" + year);
    }
}
