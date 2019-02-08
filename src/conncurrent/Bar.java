package conncurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Bar {
	private AtomicInteger count=new AtomicInteger(0);
    //private int count;
	public void increaseCount(){
		count.getAndIncrement();
		count.getAndIncrement();
		//count++;
		//count++;
		
	}

	@Override
	public String toString() {
		return "Bar [count=" + count + "]";
	}
}
