package thread;
public class Reader extends Thread{
	 
private PhoneContactListStorage phoneContactListStorage = null;
public Reader(PhoneContactListStorage d, String threadName) {
this.phoneContactListStorage = d;
this.setName(threadName);
}
 
@Override
public void run() {
while (true) {
String [] keys = phoneContactListStorage.getKeys();
if(keys!=null){
for (String key : keys) {
//reading with a READ LOCK
String value = phoneContactListStorage.get(key);
System.out.println(key + " : " + value);
}
}
try {
Thread.sleep(1000);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}