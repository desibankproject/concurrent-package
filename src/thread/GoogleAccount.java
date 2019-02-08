package thread;

public class GoogleAccount  extends Thread{
	
	private Gmail gmail;

	public GoogleAccount(Gmail gmail,String name) {
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
