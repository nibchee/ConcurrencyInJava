import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PrimeNumber_WithThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduleService = Executors.newScheduledThreadPool(1);


        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        Runnable reprterRunnabe = () -> {
            System.out.println("running report");
            System.out.println("Active Thread " + executorService.getActiveCount());
            System.out.println("Completed Threads " + executorService.getCompletedTaskCount());
        };
        scheduleService.scheduleAtFixedRate(reprterRunnabe, 1, 5, TimeUnit.SECONDS);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Pls enter n to get nth prime");
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }


            //creating thread for each new request
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculate(n);
                    System.out.println("Value of " + n + "th is " + number);
                }
            };

            executorService.execute(r);
        }


    }
}
