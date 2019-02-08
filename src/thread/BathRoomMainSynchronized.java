package thread;


public class BathRoomMainSynchronized {
	
	public static void main(String[] args) {
		
		FamilyPerson familyPerson1=new FamilyPerson("Dave","I ammmmsmsmsmmsmsm");
		FamilyPerson familyPerson2=new FamilyPerson("Michal","I am fine here");
		
		familyPerson1.start();
		familyPerson2.start();
	}

}
