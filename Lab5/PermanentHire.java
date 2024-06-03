public class PermanentHire extends SalariedWorker {
    // private blocks this object from being created this way
	public PermanentHire() {
		super();
	}
	
    public PermanentHire(String name, int social) {
		super(name, social);
	}
	
	public PermanentHire(String name, int social, double monthlyPay) {
		super(name, social, monthlyPay);
	}
    @Override
    public double calculateWeeklyPay() {
        return monthlyPay * 1.5 / 4.0;
    }
}
