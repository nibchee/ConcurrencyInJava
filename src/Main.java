import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Thread> threads=new ArrayList<>();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Pls enter n to get nth prime");
            int n = sc.nextInt();
            if (n == 0){
                System.out.println("Waiting for all Threads to finish");
                try {
                    waitForThreads(threads);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Done! "+threads.size()+" primes calculated");
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

            Thread t = new Thread(r);
            threads.add(t);
            t.start();
        }

        Runnable statusReporter=()->{
            while(true){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                printThreads(threads);
            }
        };
        Thread reporterThread=new Thread(statusReporter);
        reporterThread.start();

    }

    public static void printThreads(List<Thread> threads){
        System.out.println("\n Curently "+threads.size()+" threads runnning with status:");
        threads.forEach(thread -> {
            System.out.print(thread.getState()+" ");
        });
    }


    private static void waitForThreads(List<Thread> threads) throws InterruptedException    {
        for(Thread thread:threads){
            thread.join();
        }
    }
}