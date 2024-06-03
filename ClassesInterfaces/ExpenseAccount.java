/*
 * Not sure if I completely understand the instructions when you say:
 * "Build a class ExpenseAccount that extends (i.e., inherits from) your ArrayList." as well as,
 * "An example of questions to ask when defining an interface (for the ExpenseAccount class)" and,
 * "By this point, you should be able to design an appropriate interface to your classes as well as create an appropriate driver filled with tests."
 * Is it a interface or a class at that point?
 * 
 * This would be the basic implementation of the class.
 * "For instance, you might be interested in knowing the total amount of expenses that is outstanding in the ExpenseAccount.  
 * You might be interested in knowing which expense is next due and unpaid and how much it is."
 * 
 * Since ArrayList currently cannot be ordered (for the sake of time, kinda can't develop it right now), knowing which is next due requires sorting and just keeping it on docket. 
 * If we wanted to be more advanced, we could implement a partial payment towards that bill, like savings.  
 */

import java.util.Iterator;

public class ExpenseAccount extends ArrayList {
    //Since my ArrayList had a dynamic size to begin with, even if it might cause some memory problems, it would still work, so I'm just going to use super contructors and methods.
    private String accountName;
    private int dollars;
    private int cents;
    private Date currentDate;

    //Driver that I think should work but probably will not.
    public static void main(String[] args) throws CloneNotSupportedException {
        //Money tests
        Money money = new Money(100, 0);
        Money money2 = (Money) money.clone();
        Money money3 = new Money(100, 1);
        System.out.println(money.compareTo(money2));
        System.out.println(money.compareTo(money3));
        //Date tests
        Date date = new Date(12, 16, 2012);
        Date date2 = (Date) date.clone();
        Date date3 = new Date(5, 24, 2006);
        Date date4 = new Date(10, 24, 2006);
        System.out.println(date.compareTo(date2));
        System.out.println(date.compareTo(date3));
        //Bill tests
        Bill bill = new Bill(money3, date, date3, "Rob");
        Bill bill2 = (Bill) bill.clone();
        Bill bill3 = new Bill(money3, date3, date4, "Rob");
        System.out.println(bill.compareTo(bill2));
        System.out.println(bill.compareTo(bill3));
        //ArrayList tests
        ArrayList arrayList = new ArrayList<Bill>();
        arrayList.add(bill);
        arrayList.add(bill2);
        arrayList.add(bill3);

        //stops here, due to compiling errors in the ArrayList class.
        Iterator<Bill> it = arrayList.iterator();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(it.next().toString());
        }
        //ExpenseAccount tests
        ExpenseAccount expenseAccount = new ExpenseAccount("Rob's Expense Account", 0, 0, date3);
        expenseAccount.deposit(1000000, 0);
        expenseAccount.add(bill);
        expenseAccount.add(bill2);
        expenseAccount.add(bill3);
        Iterator<Bill> iterator = expenseAccount.iterator();
        while (iterator.hasNext()) {
            Bill currentBill = iterator.next();
            if (currentBill.getDueDate() == expenseAccount.currentDate) {
                expenseAccount.completeTransaction(currentBill.getAmount());
            }
        }
        //add to day here, and keep checking.
    }

    /**
     * Variable constructor creating a new ExpenseAccount Object.
     * @param accountName String containing a name for the account.
     * @param initialBalance double representation of the amount of money in the account. 
     */
    public ExpenseAccount(String accountName, int dollars, int cents, Date currentDate) {
        super();
        this.currentDate = currentDate;
        this.accountName = accountName;
        this.dollars = dollars;
        this.cents = cents;
    }

    /**
     * Adds an amount of money to the balance.
     * @param depositDollars int representation of the dollars to be added.
     * @param depositCents int representation of the cents to be added.
     */
    public void deposit(int depositDollars, int depositCents) {
        if (depositDollars >= 0 && depositCents >= 0 && depositCents < 100) {
            dollars += depositDollars;
            cents += depositCents;

            // Adjust cents if it exceeds 100
            dollars += cents / 100;
            cents %= 100;

            System.out.println("Deposited $" + depositDollars + "." + depositCents + " into " + accountName + ". New balance: $" + dollars + "." + cents);
        } 
        else {
            System.out.println("Invalid deposit amount. Please enter non-negative values, and cents should be less than 100.");
        }
    }

    /**
     * Deducts a monatary amount from the account.
     * @param withdrawalDollars int representation of the dollars to be subtracted.
     * @param withdrawalCents int representation of the cents to be subtracted.
     */
    public void withdraw(int withdrawalDollars, int withdrawalCents) {
        if (withdrawalDollars >= 0 && withdrawalCents >= 0 && withdrawalCents < 100) {
            int withdrawalAmountInCents = withdrawalDollars * 100 + withdrawalCents;

            if (withdrawalAmountInCents <= (dollars * 100 + cents)) {
                // Sufficient funds for withdrawal
                int remainingBalanceInCents = (dollars * 100 + cents) - withdrawalAmountInCents;

                dollars = remainingBalanceInCents / 100;
                cents = remainingBalanceInCents % 100;

                System.out.println("Withdrawn $" + withdrawalDollars + "." + withdrawalCents + " from " + accountName +
                        ". New balance: $" + dollars + "." + cents);
            } else {
                System.out.println("Insufficient funds for withdrawal from " + accountName + ".");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please enter non-negative values, and cents should be less than 100.");
        }
    }

    /**
     * Deducts a amount decided by a Money object from this ExpenseAccount object.
     * @param money Money object whose fields will be subtracted from this ExpenseAccount object.
     */
    public void completeTransaction(Money money) {
        this.withdraw(money.getDollars(), money.getCents());
    }

    /**
     * Getter method for the dollar attribute.
     * @return int value of the dollars on the account.
     */
    public int getDollars() {
        return dollars;
    }

    /**
     * Getter method for the cents attribute.
     * @return int value of the cents on the account.
     */
    public int getCents() {
        return cents;
    }

    /**
     * Getter method for the accountName attribute.
     * @return String value of the name on the account.
     */
    public String getAccountName() {
        return accountName;
    }
}