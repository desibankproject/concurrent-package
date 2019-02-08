package conncurrent;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
 
/**
 * 
 * @author nagendra.yadav
 *
 */
public class MessageExchange {
	
	public static void main(String[] args) {
        BlockingQueue <String> sharedResource = new LinkedBlockingQueue<String>(2);
        //new MessageExchange().startProducerAndConsumer();
        MessageProducer messageProducer=new MessageProducer(sharedResource,"Producer 1");
        MessageConsumer consumer1=new MessageConsumer(sharedResource,"Consumer1");
        MessageConsumer consumer2=new MessageConsumer(sharedResource,"Consumer2");
        
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        //submit() one example of method overloading
        executorService.submit(messageProducer);
        executorService.submit(consumer1);
        executorService.submit(consumer2);
        
        executorService.shutdown();
        executorService.submit(consumer2);
    }
}