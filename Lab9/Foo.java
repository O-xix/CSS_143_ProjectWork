/*
 * I will acknowledge that I essentially copied the functionality of the Multi class, because the instructions weren't exactly the best written.
 * It just prints out 999 random numbers under an increasing limit.
 */

public class Foo implements Runnable {
    String string;


    public Foo(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
    public void setString(String string) {
        this.string = string;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Foo("foo1"));
		Thread t2 = new Thread(new Foo("foo2"));
		
		t1.start();	//this calls run()
		t2.start();
    }

    @Override
    public void run() {
		for(int i = 0; i < 1000; i++) {
			if( Math.random() < .5) {  
				try {	
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(string + " : " + i);
		}
	}    
}
