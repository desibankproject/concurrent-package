package conncurrent;

public class RunnableTask implements Runnable{

	private long waitTime;
	 
	public RunnableTask(int time) {
		this.waitTime = time;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
		}
		System.out.println("Runnable is done!");	
	}
	
}
