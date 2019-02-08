package conncurrent;

import java.util.concurrent.Callable;

public class Jocker  implements Callable<String>{

	@Override
	public String call() throws Exception {
		for(int x=100;x<1000;x++){
			System.out.println(Thread.currentThread().getName()+" Jocker Calling is call!!!!!!!!!!!"+x);
		}
		return "I am Jocker and I have finished my job";
	}

}
