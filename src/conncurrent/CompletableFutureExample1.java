package conncurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample1 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Cool!");
		    return "Hello";
		}).thenApply(value-> value.toUpperCase());
		System.out.println("@))@)@");
		System.out.println("Value- " + cf.get());
	}
}
