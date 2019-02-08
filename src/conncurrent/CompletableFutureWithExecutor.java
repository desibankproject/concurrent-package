package conncurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureWithExecutor {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
			System.out.println("First = "+Thread.currentThread().getName());
			return "Hello";
		}).thenApplyAsync(value -> {
			System.out.println("Second = "+Thread.currentThread().getName());
			return value.toUpperCase();
		}, executor);

		System.out.println("Value- " + cf.get());
		executor.shutdown();
	}
}
