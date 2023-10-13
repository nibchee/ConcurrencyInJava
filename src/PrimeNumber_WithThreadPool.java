import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeNumber_WithThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

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
