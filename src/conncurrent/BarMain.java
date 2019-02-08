package conncurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BarMain {
	public static void main(String[] args) throws InterruptedException {
		Bar bar=new Bar();
		BarTask barTask1=new BarTask(500000, bar); //1
		BarTask barTask2=new BarTask(500000, bar); //200
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(barTask1);
		executor.submit(barTask2);
		executor.shutdown();
		if(executor.isTerminated()){
			System.out.println(bar);
		}
		System.out.println("Please wait!!!!!!!!!!!!!");
		Thread.sleep(10000);
		System.out.println(bar);
	}
}
