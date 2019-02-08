package thread;

public class Writer extends Thread{
	   private PhoneContactListStorage phoneContactListStorage = null;
	 
	   public Writer(PhoneContactListStorage d, String threadName) {
	     this.phoneContactListStorage = d;
	     this.setName(threadName);
	   }
	   @Override
	   public void run() {
	     while (true) {
	       String [] keys = phoneContactListStorage.getKeys();
	       for (String key : keys) {
	         String newValue = getNewValueFromDatastore(key);
	         //writing with WRITE LOCK
	         phoneContactListStorage.set(key, newValue);
	       }
	 
	       try {
	         Thread.sleep(1000);
	       } catch (InterruptedException e) {
	         e.printStackTrace();
	       }
	     }
	   }
	 
	   public String getNewValueFromDatastore(String key){      
	     return  phoneContactListStorage.get(key);
	   }
	}