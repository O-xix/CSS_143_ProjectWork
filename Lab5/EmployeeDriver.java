import java.util.ArrayList;

/*
 * Driver for Lab 5
 *
 * A simple driver to exercise the Employee hierarchy
 */
public class EmployeeDriver {
    public static void main(String[] args) {
        Accountant emp1 = new Accountant("Rick", 123456789);
        // this next employee makes a bit more than Rick
        Accountant emp2 = new Accountant("Tim", 55555555, 10000);
        // and lets make an hourly worker
        HourlyWorker emp3 = new HourlyWorker("Jim", 11111111);
        // then a salaried worker
        SalariedWorker emp4 = new SalariedWorker("Jane", 222222222, 5000);
        HourlyWorker emp5 = new HourlyWorker("Joe", 11111111, 20);

        // TODO Build some PermanentHire and Consultant objects here
        //PermanentHire objects
        PermanentHire emp6 = new PermanentHire("Jimmy", 02265454, 10750);
        PermanentHire emp7 = new PermanentHire("Jimini", 92780454, 10751);
        //Consultant emp7
        Consultant emp8 = new Consultant("Jimbo", 12349048, 60);
        Consultant emp9 = new Consultant("Jizo", 12340948, 61);
        // and add them to the ArrayList below

        // Build a set of workers, all of which are employees
        ArrayList<Employee> myEmployees = new ArrayList<Employee>();

        myEmployees.add(emp1);
        myEmployees.add(emp2);
        myEmployees.add(emp3);
        myEmployees.add(emp4);
        myEmployees.add(emp5);
        myEmployees.add(emp6);
        myEmployees.add(emp7);
        myEmployees.add(emp8);
        myEmployees.add(emp9);

        // TODO Add a sixth and seventh employee to this list that you create
        
        // "Using the EmployeeDriver, build a ColorWithAlpha and try to add it to the ArrayList of employees. What error do you encounter? What does this mean?"
        //ColorWithAlpha colorWithAlpha = new ColorWithAlpha(90);
        //myEmployees.add(colorWithAlpha);
        /*
         * Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
         * The method add(Employee) in the type ArrayList<Employee> is not applicable for the arguments (ColorWithAlpha)
         * 
         * Just can't add that type because of the overridden method.
         */
        /*
         * "Using the EmployeeDriver, build a ColorException and try to add it to the ArrayList of employees. 
         * What error do you encounter? 
         * What if you wanted the ArrayList to store both employees and color exceptions—how would this change the way ArrayList is declared?"
         * 
         * We already did this in the previous problem-ish, the array would have to be able to use a shared super class of ColorException and Employee like the Object class. 
         */

        // This code doesn't need to change, even if you add ten new employee classes and
        // add 102 new employees - this is an example of the generic code that can be written
        // when inheritance hierarchies are in use.
        for (int i = 0; i < myEmployees.size(); i++) {
            Employee current = myEmployees.get(i);
            System.out.println(current.getName() + " makes " + current.calculateWeeklyPay() + " per week.");
        }
    }
}
