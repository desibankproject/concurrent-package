package thread;

//Omega is thread??????? no no .. it is task
public class Theata  implements Runnable {

	@Override
	public void run() {
		 Thread t=Thread.currentThread();
			for(int i=1;i<=300;i++) {
				System.out.println(t.getName()+" is Theata malodious song ...... = "+i);
				System.out.println(t.getName()+" is Theata malodious song ...... = "+i);
				System.out.println(t.getName()+" is singing Theata song ...... = "+i);
			}
	}

}
