package conncurrent;

import java.util.concurrent.Semaphore;

/**
 * This post helps to explore more into java.util.concurrent package. It
 * explains java.util.concurrent.Semaphore class with example. Many time while
 * developing multi threaded application , we may have multiple threads
 * accessing particular system resource concurrently. If you want to limit no of
 * open request for the resource then Semaphore is the option available in java.
 * Limiting no of open request we can improve throughout of a system. Using
 * Semaphore we can control no of running thread at a time out of all available
 * running threads.
 * 
 * @author DELL
 * 
 */
class SemaphoreTest {
	public static void main(String[] args) throws InterruptedException {
		// Limiting No on threads running to 2 8:
		Semaphore semaphore = new Semaphore(2);
		OhMyThread[] threads=new OhMyThread[5];
		for (int i = 0; i < 5; i++) {
			threads[i]=new OhMyThread(String.valueOf(i), semaphore);
			threads[i].start();
		} // 12:
		
		for (int i = 0; i < 5; i++) {
			threads[i].join();
		}
		System.out.println("End of Semaphore Test");
	}
}

/**
 * nagendra.yadav
 */
class OhMyThread extends Thread {
	private String name;
	private Semaphore semaphore;

	public OhMyThread(String name, Semaphore semaphore) {
		this.name = name;
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			semaphore.acquire();
			for(int i=1;i<=20;i++){
					System.out.println("Thread " + name + "is start running ="+i);
					sleep(500);
			}
			
			semaphore.release();
			System.out.println("Thread " + name + " Ends");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
