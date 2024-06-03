/**
 Simple driver to test Money, Date, and Bill classes
 @author Rob Nash, borrowed from cfolsen
 */
public class BillMoneyDateDriver
{

    /**
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
     */
    public static void main(String[] args)
    {
        //Construct some money
        Money money1 = new Money(10);
        Money money2 = new Money(money1);
        money1.setMoney(30,50);
        //TODO: do more functional exercises with the money class
	    
	    
        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money2);
	
	
        //Construct some bills
        Money amount = new Money(20);
        Date dueDate = new Date(4, 30, 2007);
        Bill bill1 = new Bill(amount, dueDate, "The phone company");
       
        Bill bill2 = new Bill(bill1);
        bill2.setDueDate(new Date(5, 30, 2007));
        amount.setMoney(31, 99);
        dueDate.setDay(29);
        Bill bill3 = new Bill(amount, dueDate, "The record company");
        
        System.out.println("Bill objects output:");
        System.out.println(bill1);
        System.out.println(bill2);
        System.out.println(bill3);
        
        //My tests:
        //Testing Date class:
        Date testDate = new Date(dueDate);
        System.out.println(testDate);
        System.out.println(testDate.equals(dueDate));
        testDate.setDay(0);
        testDate.setMonth(0);
        testDate.setYear(1001);

        //Testing Money class:
        Money testMoney = new Money(100, 100);
        System.out.println(testMoney.getCents());
        System.out.println(testMoney.getDollars());
        testMoney.setCents(200);
        testMoney.setDollars(1000);
        System.out.println(testMoney.getMoney());
        testMoney.add(amount);
        testMoney.add(24);
        testMoney.add(36, 9);
        System.out.println(testMoney.equals(amount));

        //Testing Bill class:
        System.out.println(bill1.getDueDate());
        System.out.println(bill1.getOriginator());
        System.out.println(bill1.isPaid());
        bill1.setPaid(dueDate);
        bill1.setUnpaid();
        bill1.setAmount(amount);
        System.out.println(bill1.getAmount());
        bill1.setOriginator("Gustav");
        System.out.println(bill1.equals(bill3));
        System.out.println(bill1);
        bill1.setPaid(testDate);
    }
}
