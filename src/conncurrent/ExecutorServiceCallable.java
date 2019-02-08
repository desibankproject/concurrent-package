package conncurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import thread.Omega;
import thread.Theata;

public class ExecutorServiceCallable{
	
	  public static void main(String[] args) throws InterruptedException, ExecutionException {
		  	//Create Thread pools
		     ExecutorService executor=Executors.newFixedThreadPool(2);
		     Pocker pocker=new Pocker();
		     Jocker jocker=new Jocker();
		     Future<String> result1=executor.submit(pocker);
		     Future<String> result2= executor.submit(jocker);
		     String tt1=result1.get();
		     String tt2=result2.get();
		     System.out.println(tt1);
		     System.out.println(tt2);
			  
	  }

}
