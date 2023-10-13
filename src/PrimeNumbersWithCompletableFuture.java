import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeNumbersWithCompletableFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nI can tell nth prime, ENter n");
            int n = sc.nextInt();
            if (n == 0) break;

            //here it leverages executor service
            CompletableFuture.supplyAsync(() -> PrimeNumberUtil.calculate(n), executorService)
                    .thenAccept((Integer ret) -> System.out.println(ret));
        }
    }
}
