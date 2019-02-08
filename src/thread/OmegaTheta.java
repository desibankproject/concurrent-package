package thread;

public class OmegaTheta {
	public static void main(String[] args) {
		Omega omega=new   Omega();
		Theata theata=new Theata();
		Thread t1=new Thread(omega);
		Thread t2=new Thread(theata);
		t1.start();
		t2.start();
		
	}
}
