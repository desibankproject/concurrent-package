package thread;
public class BathRoom {
	
	synchronized public void too() {
		System.out.println("__#(#(#((too __________");
		System.out.println("__#(#(#((too __________");
	}
	
	synchronized public void foo() {
		System.out.println("__#(#(#((foo __________");
		System.out.println("__#(#(#((foo __________");
		System.out.println("__#(#(#((foo __________");
	}
	
	synchronized  public static void takeBath(String name, String song) {
		System.out.println("Hey I am = " + name);
		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": I am singing ...." + song);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	synchronized public  void ahaha(String name, String song) {
		System.out.println("Hey I am = " + name);
		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": I am singing ...." + song);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
