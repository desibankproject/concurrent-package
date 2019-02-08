package thread;

// I want this class , should become a thread
public class VedioPlayer extends Thread{
	
	private Thread musicPlayer;

	public VedioPlayer(String name,Thread musicPlayer){
		super(name); //I am calling constructor of parent class
		this.musicPlayer=musicPlayer;
	}
	
	@Override
	public void run() {
		//video should join music player
			 try {
				musicPlayer.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		 Thread t=Thread.currentThread();
		for(int i=1;i<=300;i++){
			System.out.println(t.getName()+" is playing vedio ...... = "+i);
		}
	}

}
