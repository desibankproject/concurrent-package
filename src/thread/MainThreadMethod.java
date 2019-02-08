package thread;

public class MainThreadMethod {
	
	//method is always called by the thread
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//if i want to get reference of the thread who is calling
		//this method. i can do a shown below
		Thread t=Thread.currentThread(); //currentThread is static method of Thread class 
		
		System.out.println("thread id = "+t.getId());
		System.out.println("thread name = "+t.getName());
		//There is two type of thread
		//deamon and non deamon
		//main thread is non deamon
		System.out.println("is main deamon = "+t.isDaemon());
		//We cannot make main thread deamon
		
		///getting state
		System.out.println("is main thread state = "+t.getState());
		
		t.setName("nagendra");
		System.out.println("now main thread name is  = "+t.getName());
		
		System.out.println("now main thread priority is  = "+t.getPriority());
		
		

	}

}
