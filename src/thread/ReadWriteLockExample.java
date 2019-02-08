package thread;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
 
/**
 * 
 * @author nagendra.yadav
 *
 */
class PhoneContactListStorage {
 
   private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
 
   private final Lock read  = readWriteLock.readLock();
 
   private final Lock write = readWriteLock.writeLock();
 
   private HashMap<String, String> contactList = new HashMap<String, String>();
 
   public void set(String key, String value) {
   if(write.tryLock()){
   System.out.println("aquired write lock");
     try {
     contactList.put(key, value);
     } finally {
       write.unlock();
     }
   }else{
   System.out.println("Not able to aquire write lock");
   }
   }
 
   public String get(String key) {
   if(read.tryLock()){
   System.out.println("aquired read lock - get(String key) ");
     try{
       return contactList.get(key);
     } finally {
       read.unlock();
     }
   }else{
     System.out.println("Not able to aquire read lock - get(String key)");
     return null;
    }
   }
 
   public String[] getKeys(){
    if(read.tryLock()){
     System.out.println("aquired read lock - String[] getKeys()");
     try{
       String keys[] = new String[contactList.size()];
       return contactList.keySet().toArray(keys);
     } finally {
       read.unlock();
     }
    }else{
     System.out.println("Not able to aquire read lock - String[] getKeys()");
     return null;
    }
   }
}
 
public class ReadWriteLockExample{
   public static void main(String[] args) {
   PhoneContactListStorage contactListStorage = new PhoneContactListStorage();
   contactListStorage.set("0984512674",  "Ram");
   contactListStorage.set("0994512674", "Sam");
     Writer writer  = new Writer(contactListStorage, "Writer");
     Reader reader1 = new Reader(contactListStorage ,"Reader 1");
     Reader reader2 = new Reader(contactListStorage ,"Reader 2");
     Reader reader3 = new Reader(contactListStorage ,"Reader 3");
     writer.start();
     reader1.start();
     reader2.start();
     reader3.start();
   }
 
}