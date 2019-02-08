package conncurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class DataSummerMainWithCallable {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
			List<Future<Integer>>  taskresults=new ArrayList<Future<Integer>>();
			ExecutorService  executorService=Executors.newFixedThreadPool(5);

			for(int x=0;x<5;x++){
					DataSummer50 task50=new DataSummer50();
					Future<Integer> result50=executorService.submit(task50);
					DataSummer10 task10=new DataSummer10();
					Future<Integer> result10=executorService.submit(task10);
					taskresults.add(result50);
					taskresults.add(result10);
			}
			
			
			int finalResult=0;
			for(Future<Integer> remote:taskresults){
				Integer integer=remote.get(); // synchronous call - call is blocked
				finalResult=finalResult+integer;
			}
			System.out.println("finalResult =  "+finalResult);
	}

}
