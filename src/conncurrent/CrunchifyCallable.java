package conncurrent;

import java.util.concurrent.Callable;

public class CrunchifyCallable implements Callable<String> {
	 
	private long waitTime;
 
	public CrunchifyCallable(int time) {
		this.waitTime = time;
	}
 
	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
		return Thread.currentThread().getName();
	}
}