package conncurrent;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static final ReentrantLock locks = new ReentrantLock();
    // Runnable thread
    class ThreadA implements Runnable {
        @Override
        public void run() {
            try {
            	
                if (locks.isHeldByCurrentThread()) {
                    System.out.println("ThreadA has locked the control and working their task...");
                    Thread.sleep(2000);
                    System.out.println("ThreadA has completd its task...");
                }
            } catch (final Exception e) {
                e.printStackTrace();
            } finally {
                locks.unlock();
            }
        }
    }

    // Runnable thread
    class ThreadB implements Runnable {
        @Override
        public void run() {
            try {
                locks.lock();
                if (locks.isHeldByCurrentThread()) {
                    System.out.println("ThreadB has locked the control and working their task...");
                }

            } catch (final Exception e) {
                e.printStackTrace();
            } finally {
                locks.unlock();
            }
        }
    }

    public static void main(final String[] args) throws Exception {
       
    	final ExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.execute(new ReentrantLockTest().new ThreadA());
        executor.execute(new ReentrantLockTest().new ThreadB());
        executor.awaitTermination(4, TimeUnit.SECONDS);
        executor.shutdownNow();
    }
}