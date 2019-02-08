package thread;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class EatMango implements Runnable {
	
	@Override
	public void run()  {
		for(int i=0;i<10;i++) {
			System.out.println("I am eating mango of number = "+(i+1));
		}
	}
}


class EatApple implements Runnable {
	@Override
	public void run()  {
		for(int i=0;i<10;i++){
			System.out.println("I am eating apple of number = "+(i+1));
			try {
				Thread.sleep(1000);//InterruptedException is a checked exception
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ExecutorsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//Here we are creating thread pool of three threads
		//and interfacing it with Executor
	    Executor executor=Executors.newCachedThreadPool();
	    
	    executor.execute(new EatMango());
	    executor.execute(new EatApple());
	    executor.execute(new EatApple());
	    executor.execute(new EatMango());
	    
	    System.out.println("This is magic of concurrent package...........");
	    System.out.println("This is magic of concurrent package...........");
	    System.out.println("This is magic of concurrent package...........");
	    System.out.println("This is magic of concurrent package...........");
	    System.out.println("This is magic of concurrent package...........");
	    System.out.println("This is magic of concurrent package...........");
	    System.out.println("This is magic of concurrent package...........");

	}

}
