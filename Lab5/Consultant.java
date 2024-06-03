public class Consultant extends HourlyWorker {
    
	
	public Consultant() {
		super();
	}
	public Consultant(String name, int social) {
		super(name, social);
	}
	
	public Consultant(String name, int social, double hourlyPay) {
		super(name, social, hourlyPay);
	}
    @Override
    public double calculateWeeklyPay() {
        return hourlyPay * 3;
    }
}
