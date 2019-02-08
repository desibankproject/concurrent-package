package conncurrent;

import java.util.concurrent.Callable;


public class DataSummer10 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		//Doing some calculation for 2 seconds
		Thread.sleep(1000);
		return 10;
	}

}
