import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Pls enter n to get nth prime");
            int n=sc.nextInt();
            if(n==0)
                break;
            int number=PrimeNumberUtil.calculate(n);
            System.out.println("Value of nth is "+number);
        }
    }
}