package thread;


public class CarBikeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//main is non daemon thread!!!!!!!!!!!!
			
		// Create task first
		Car car = new Car("BMW");
		Bike bike = new Bike("Apache");
		
		// in above instance we do not have any multi threading feature so far.
		// so adding thread feature now
		Thread t1 = new Thread(car);
		Thread t2 = new Thread(bike);
		t1.start();
		t2.start();

		for (int p = 9; p < 99; p++) {
			System.out.println("_____OHHH I am main!!!!!!!!!!!!!!!!!!!!!! = "
					+ p);
		}

		System.out.println("BT1 is alive = "+t1.isAlive());
		System.out.println("BT2 is alive = "+t2.isAlive());
		
		// join
		// here main thread can join t1 and t2 thread
		try {
			t1.join(); //10 sec
			t2.join(); //20 sec
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean t=true;
		while(t){
			System.out.println("_enjoying__________");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		System.out.println("T1 is alive = "+t1.isAlive());
		System.out.println("T2 is alive = "+t2.isAlive());

		System.out.println("_______WELCOME @@@@@@@@@@@@@@@@ WELCOME");
		System.out.println("_______WELCOME @@@@@@@@@@@@@@@@ WELCOME");

	}

}
