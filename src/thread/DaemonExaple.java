package thread;

public class DaemonExaple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create task first
		Car car = new Car("BMW");
		Bike bike = new Bike("Apache");
		// in above instance we do not have any multi threading feature so far.
		// so adding thread feature now

		Thread t1 = new Thread(car);
		Thread t2 = new Thread(bike);
		t1.setDaemon(true);
		t2.setDaemon(true);

		t1.start();
		t2.start();
		
		t1.setDaemon(true);
		t2.setDaemon(true);

		for (int p = 9; p < 99; p++) {
			System.out.println("_____OHHH I am main!!!!!!!!!!!!!!!!!!!!!! = "
					+ p);
		}

		
		
		System.out.println("T1 is alive = "+t1.isAlive());
		System.out.println("T2 is alive = "+t1.isAlive());

		System.out.println("_______WELCOME @@@@@@@@@@@@@@@@ WELCOME");
		System.out.println("_______WELCOME @@@@@@@@@@@@@@@@ WELCOME");

	}

}
