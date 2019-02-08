package thread;


//This Bike class is not thread ?? yes
//this is a task
public class Bike implements Runnable{
	
	private String tname;
	
	public Bike(String tname){
		this.tname=tname;
	}

	@Override
	public void run(){
		for(int i=3;i<333;i++){
			System.out.println(tname +" Bike is running  ... .. . "+i);
		}
		
	}
}
