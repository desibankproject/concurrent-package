package conncurrent;

import java.util.concurrent.Callable;

public class Pocker  implements Callable<String>{

	@Override
	public String call() throws Exception {
		for(int x=100;x<1000;x++){
			System.out.println(Thread.currentThread().getName()+" Pocker Calling is call!!!!!!!!!!!"+x);
		}
		return "I am pocker and I have finished my job";
	}

}
