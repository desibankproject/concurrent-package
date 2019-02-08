package conncurrent;

import java.util.concurrent.CyclicBarrier;

public class JoshTask implements Runnable {

	private String name;
	private int sleep;
	private CyclicBarrier barrier;

	public JoshTask(String name, int sleep, CyclicBarrier barrier) {
		this.name = name;
		this.sleep = sleep;
		this.barrier = barrier;
	}

	public void run() {
		try {
			System.out.println(name + ": started");
			System.out.println(name + ": 1st time sleeping " + sleep);
			Thread.sleep(sleep);

			// all threads need to wait for each other to get to this point
			System.out.println(name + ": 1st time waiting");
			barrier.await();

			System.out.println(name + ": 2nd time sleeping " + sleep);
			Thread.sleep(sleep);

			// all threads need to wait for each other to get to this point
			System.out.println(name + ": 2nd time waiting");
			barrier.await();

			System.out.println(name + ": finished");

		} catch (Exception e) {
		}
	}
}