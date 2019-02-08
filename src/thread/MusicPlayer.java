package thread;

// I want this class , should become a thread
public class MusicPlayer extends Thread {
	
	public MusicPlayer(String name) {
		super(name); //I am calling constructor of parent class
	}
	
	@Override
	public void run() {
		 Thread t=Thread.currentThread();
		for(int i=1;i<=300;i++) {
			System.out.println(super.getName()+" is singing malodious song ...... = "+i);
			System.out.println(super.getName()+" is singing malodious song ...... = "+i);
			System.out.println(super.getName()+" is singing malodious song ...... = "+i);
		}
	}

}
