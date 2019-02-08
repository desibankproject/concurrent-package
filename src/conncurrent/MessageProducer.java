package conncurrent;
import java.util.concurrent.BlockingQueue;


/**
 * 
 * @author nagendra.yadav
 *
 */
public class MessageProducer implements Runnable {

	private BlockingQueue<String> sharedResource;
    private String tname;
    private boolean stopProducing;
    
	 public MessageProducer(BlockingQueue<String> sharedResource, String tname) {
		this.sharedResource = sharedResource;
		this.tname = tname;
	}
	public MessageProducer() {
	}

	public void run() {
          try {
          	int count=0;
          	
          	while(true) {
          		count++;
          		if (!sharedResource.offer("Hello Message = "+count)) {
  					/*
  					 * The non-blocking offer() method returns false if it was
  					 * not possible to add the element to this queue.
  					 */
  					long start = System.currentTimeMillis();
  					/*
  					 * Now use the put method as its a blocking call and it wail
  					 * until the queue space is available.
  					 */
  					sharedResource.put("Hello Message = "+ ++count);
  					
  					System.out.println("Data is added into the queue by "+tname+" ! = "+"Hello Message = "+ count);
  					System.out
  							.println("It seems Consumer is slow. "+tname+" waited for "
  									+ (System.currentTimeMillis() - start)
  									+ "ms");
  				}else {
  				  System.out.println("Data is added into the queue by "+tname+" ! = "+"Hello Message = "+ count);
  				}
  				Thread.sleep(5000);
  				if (stopProducing) {
  					break;
  				}
              }
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
}
