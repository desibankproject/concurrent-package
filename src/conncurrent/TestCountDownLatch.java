package conncurrent;


import java.util.*;  
import java.util.concurrent.*;  

/**
 * @author Nagendra
 * 
 *         Practical Example : Main thread creates 10 Database Connections and
 *         Creates 10 different Threads and assigns those DB connection to the
 *         threads one each. But the Main thread must wait until all 10 Threads
 *         finish their DB Operation before closing the DB Connections. Children
 *         will exit after performing the DB Operation. A CountDownLatch can be
 *         used in this scenario.
 * 
 */
public class TestCountDownLatch{
	public static void main(String[] args) throws Exception {
		
		 //This gloabal variable shared among many threads
	     List<String> horseList = Collections.synchronizedList(new ArrayList<String>());  
 		
	   //all horse threads wait for only one start latch 10:
		CountDownLatch startLatch = new CountDownLatch(1); 
	 		//all horse has to pass end latch , so initiating with no of horses
		CountDownLatch endLatch = new CountDownLatch(5); 
		
		for(int i=0;i<5;i++){ 
			new HorseThread(String.valueOf(i), 
					startLatch,endLatch,horseList).start(); 
	    }  	
		//Start the race 
		startLatch.countDown();
		    //wait till a endLatch count is 0 (endLatch.countDown() called 5 times)
		   ///here main thread waiting for all the other threads
		   //main will continue when endLatch value will be zero
			endLatch.await(); //join
			
			System.out.println("First position Horse is Horse No " +  
					horseList.get(0));
		 		System.out.println("Second position Horse is Horse No " + 
					horseList.get(1)); 
		 		System.out.println("Third position Horse is Horse No " + 
						horseList.get(2)); 
		 		System.out.println("Fourth position Horse is Horse No " + 
						horseList.get(3)); 
		 		System.out.println("Fifth position Horse is Horse No " + 
						horseList.get(4)); 
 	}  } 




class HorseThread extends Thread { 
 	
	private String horseId;
 	private CountDownLatch startLatch, endLatch; 
 	List<String> list;
 	
 	public HorseThread(String horseId, 
 			CountDownLatch startLatch,CountDownLatch endLatch,List<String> list) {
 		this.horseId = horseId;
 		this.startLatch = startLatch; 
 		this.endLatch = endLatch;
 		this.list = list;
 	} 
 	
 	@Override
 	public void run(){ 
 		try { 
 			//wait till start latch opened 
 			startLatch.await(); 
 			sleep(new Random().nextInt(10)*100);
 			//notify race end crossed,endLatch decrease count; 
 			endLatch.countDown(); 
 			list.add(horseId); 
 			//System.out.println("Horse "+horseId +" has completed."); 
 			} catch(Exception exp){
 				exp.printStackTrace();  
 			}
 			
 	} 
}
