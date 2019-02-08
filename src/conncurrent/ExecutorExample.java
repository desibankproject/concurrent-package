package conncurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import thread.Omega;
import thread.Theata;

public class ExecutorExample{
	
	  public static void main(String[] args) {
		
		  	//Create Thread pools
		     Executor executor=Executors.newFixedThreadPool(3);
		     Omega task1=new   Omega();
			Theata task2=new Theata();
			executor.execute(task1);
			executor.execute(task2);
			Theata task3=new Theata();
			executor.execute(task3);
			Omega task4=new   Omega();
			executor.execute(task4);
	  }

}
