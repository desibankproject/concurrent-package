package conncurrent;

import java.util.concurrent.Callable;

public class BarTask implements Callable<String> {
	
	private  int times;
	private Bar bar;
	public BarTask(int times,Bar bar){
		this.times=times;
		this.bar=bar;
	}
	

	@Override
	public String call() throws Exception {
		 for(int x=0;x<times;x++) {
			 bar.increaseCount();
		 }
		return null;
	}

}
