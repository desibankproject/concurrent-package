package thread;

public class MainIsThread {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//how many threads are created ?? 2 but they are just in born state
		MusicPlayer musicPlayer1=new MusicPlayer("Sony");
		MusicPlayer musicPlayer2=new MusicPlayer("Sony");
		MusicPlayer musicPlayer3=new MusicPlayer("Sony");
		
		
		musicPlayer1.start();
		musicPlayer2.start();
		musicPlayer3.start();
		
		musicPlayer1.join();
		musicPlayer2.join();
		musicPlayer3.join();
		
		System.out.println("Hey!!!!!!!!!!!!!!! !we have completed");
		
}
}