package thread;
public class FamilyPerson extends Thread {
	
	private String song;

	public FamilyPerson(String name, String song) {
		super(name);
		this.song = song;
	}

	@Override
	public void run() {
		BathRoom.takeBath(getName(), song);
	}

}
