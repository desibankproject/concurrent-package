package conncurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	 
	   public static void main(String args[]) 
	      throws InterruptedException,BrokenBarrierException {
	 
	      CyclicBarrier barrier=new CyclicBarrier(3);
	 
	      // create three threads passing a name, sleep time, and cyclic barrier 
	      Thread T1 = new Thread(new JoshTask("T1",3000,barrier));
	      Thread T2 = new Thread(new JoshTask("T2",2000,barrier));
	      Thread T3 = new Thread(new JoshTask("T3",1000,barrier));
	 
	      // start all three threads
	      T1.start(); 
	      T2.start();
	      T3.start();
	 
	   }
	}