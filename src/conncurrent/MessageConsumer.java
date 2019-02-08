package conncurrent;


import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author nagendra.yadav
 *
 */
public class MessageConsumer  implements Runnable{
	private BlockingQueue<String> sharedResource;
    private String tname;
    private boolean stopConsuming;
	 public MessageConsumer(BlockingQueue<String> sharedResource, String tname) {
		this.sharedResource = sharedResource;
		this.tname = tname;
	}
	public MessageConsumer() {
	}
	@Override
	public void run() {
		while (true) {
			
			Object objectFromQueue = sharedResource.poll();
			if (objectFromQueue == null) {
				long start = System.currentTimeMillis();
				/**
				 * Now use the blocking take() method which can wait for the
				 * object to be available in queue.
				 */
				try {
					objectFromQueue = sharedResource.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Data is consumed! by "+tname+" =  "+objectFromQueue);
				System.out
						.println("It seems Producer is slow. "+tname+" waited for "
								+ (System.currentTimeMillis() - start)
								+ "ms");
			}
			else{
				System.out.println(objectFromQueue+ " is consumed by the "+tname+"!!!");
			}
			if (stopConsuming) {
				break;
			}
		}
		
	}
}
