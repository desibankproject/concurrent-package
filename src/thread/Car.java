package thread;


//This Car class is not thread ?? yes
//this is a task
public class Car implements Runnable{
	
	private String tname;
	
	public Car(String tname){
		this.tname=tname;
	}
	
	@Override
	public void run(){
		for(int i=3;i<333;i++){
			System.out.println(tname +" Car is running  ... .. . "+i);
		}
	}
	
}
