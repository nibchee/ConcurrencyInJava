import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class PrimeNumberWithSemaphores {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, true);

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
                    try {
                        //here 3 threads can acess concurrently
                        semaphore.acquire();
                        System.out.println("Now calculating for" + n);
                        int number = PrimeNumberUtil.calculate(n);
                        System.out.println("Value of " + n + "th is " + number);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted while acquiring");
                    } finally {
                        semaphore.release();
                    }
                }
            };

            Thread t = new Thread(r);
            t.start();
        }


    }

}
