import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Pls enter n to get nth prime");
            int n = sc.nextInt();
            if (n == 0)
                break;

            //creating thread for each new request
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculate(n);
                    System.out.println("Value of " + n + "th is " + number);
                }
            };

            Thread t = new Thread(r);
            t.start();

        }
    }
}