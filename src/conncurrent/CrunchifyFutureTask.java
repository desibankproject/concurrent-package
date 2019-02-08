package conncurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CrunchifyFutureTask {
	 
	public static void main(String[] args) {
		
		CrunchifyCallable crunchifyCallable1 = new CrunchifyCallable(2000);
		CrunchifyCallable crunchifyCallable2 = new CrunchifyCallable(4000);
		RunnableTask runnableTask=new RunnableTask(5000);
 
		FutureTask<String> futureTask1 = new FutureTask<String>(
				crunchifyCallable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(
				crunchifyCallable2);
		
		FutureTask<String> futureTask3 = new FutureTask<String>(runnableTask,"Mocha");
 
		// Creates a thread pool that reuses a fixed number of threads operating
		// off a shared unbounded queue. At any point, at most nThreads threads
		// will be active processing tasks.
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(futureTask1);
		executor.execute(futureTask2);
		executor.execute(futureTask3);
 
		while (true) {
			try {
				if (futureTask1.isDone() && futureTask2.isDone() && futureTask3.isDone()) {
					System.out.println("Done");
					// Initiates an orderly shutdown in which previously
					// submitted tasks are executed, but no new tasks will be
					// accepted. Invocation has no additional effect if already
					// shut down.
					System.out.println("FutureTask1 output="
							+ futureTask1.get());
					System.out.println("FutureTask2 output="
							+ futureTask2.get());
					System.out.println("FutureTask3 output="
							+ futureTask3.get());
					executor.shutdown();
					return;
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} 
		}
	}
}