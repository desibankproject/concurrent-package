package conncurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import thread.Omega;
import thread.Theata;

public class ExecutorServiceExample{
	
	  public static void main(String[] args) {
		
		  	//Create Thread pools
		     ExecutorService executor=Executors.newFixedThreadPool(3);
		     Omega task1=new   Omega();
			Theata task2=new Theata();
			executor.execute(task1);
			executor.execute(task2);
			Theata task3=new Theata();
			executor.execute(task3);
			
			executor.shutdown();
			System.out.println("@_)_@)@)@)@");
			System.out.println("@_)_@)@)@)@");
			System.out.println("@_)_@)@)@)@");
			
			Omega task4=new   Omega();
			executor.execute(task4);
	  }

}
