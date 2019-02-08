package thread;

public class YahooAccount  extends Thread{
	
	private Gmail gmail;

	public YahooAccount(Gmail gmail,String name) {
		super(name);
		this.gmail = gmail;
	}
	
	@Override
	public void run(){
		for(int x=0;x<5;x++) {
				gmail.show();
		} 
	}

}
