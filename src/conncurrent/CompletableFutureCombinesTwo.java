package conncurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCombinesTwo {
		public static void main(String[] args) throws InterruptedException, ExecutionException {
			CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			    return "Combining two CompletableFutures";
			});

			CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			    return "and getting a new CompletableFuture";
			});

			CompletableFuture<String> result = future1.thenCombine(future2, (str1, str2) -> str1 + " " + str2);
			System.out.println("Value- " + result.get());
		}
}
