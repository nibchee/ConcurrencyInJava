import java.util.concurrent.ForkJoinPool;

public class PrimeNumber_WithForkJoin {

    public void runForkJoin() {
        int[] inputarrays = {1, 2, 3, 4};
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        CalculatePrimeTask calculatePrimeTask = new CalculatePrimeTask(inputarrays, 0, inputarrays.length - 1);
        Integer sum = forkJoinPool.invoke(calculatePrimeTask);
        System.out.println("Sum of primes is " + sum);
    }

    public static void main(String[] args) {
        new PrimeNumber_WithForkJoin().runForkJoin();
    }
}
