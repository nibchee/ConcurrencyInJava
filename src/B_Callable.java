import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class B_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> futures = new ArrayList<>();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Pls enter n to get nth prime");
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }


            //creating thread for each new request
            Callable<Integer> c = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return PrimeNumberUtil.calculate(n);
                }
            };
            ExecutorService executorService = Executors.newCachedThreadPool();
            Future<Integer> primeNumberFuture = executorService.submit(c);
            futures.add(primeNumberFuture);
            Iterator<Future<Integer>> iterator = futures.iterator();

            while (iterator.hasNext()) {
                Future<Integer> f = iterator.next();
            }
        }


    }
}