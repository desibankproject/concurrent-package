package thread;

public class MusicVedioPlayerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//how many threads are created ?? 2 but they are just in born state
		MusicPlayer musicPlayer=new MusicPlayer("Sony");
		VedioPlayer vedioPlayer=new VedioPlayer("VLC",musicPlayer);
		musicPlayer.run();
		vedioPlayer.run();
		//musicPlayer.start(); //
		//musicPlayer.start(); //IllegalThreadStateException
		//vedioPlayer.start();
		
		//this logic will be executed by main thread
		for(int i=9;i<300;i++) {
					System.out.println("___AHAHAHHAH I am main+++++++++");
		}

	}

}
