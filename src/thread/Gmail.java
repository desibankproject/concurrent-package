package thread;

public class Gmail {
	
	private int x=0;
	
	public synchronized void show() {
		Thread t=Thread.currentThread();
		for(int i=1;i<=10;i++) {
			x=x+1;
			System.out.println("x= "+x+" from thread -> "+t);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
