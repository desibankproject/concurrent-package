package thread;

//Omega is thread??????? no no .. it is task
public class Omega   implements Runnable {

	@Override
	public void run()   {
		 Thread t=Thread.currentThread();
			for(int i=1;i<=300;i++) {
				System.out.println(t.getName()+" is singingOmega malodious song ...... = "+i);
				System.out.println(t.getName()+" is singinOmegag malodious song ...... = "+i);
				System.out.println(t.getName()+" is singing Omegamalodious song ...... = "+i);
				try {
					Thread.sleep(1222);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}

}
