/*
 * SalariedWorker.java
 *
 * This worker calculates her weekly pay differently than an hourly
 * worker does, so we override the calculateWeeklyPay method.
 */
public class SalariedWorker extends Employee {
    protected double monthlyPay;

    public SalariedWorker() {
        super();
    }

    public SalariedWorker(String name, int social) {
        super(name, social);
    }

    public SalariedWorker(String name, int social, double pay) {
        super(name, social);

        if (pay > 0.0) {
            monthlyPay = pay;
        }
    }

    public double calculateWeeklyPay() {
        return monthlyPay / 4;
    }
}
