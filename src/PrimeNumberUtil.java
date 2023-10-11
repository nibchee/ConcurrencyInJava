public class PrimeNumberUtil{

    public  static int calculate(int n) {
        int number=1;
        int numberOfPimesFound=0;

        int i;
        while(numberOfPimesFound<n){
            number++;
          for( i=2;i<=number && number%i!=0;i++){

          }

          if(i==number){
              numberOfPimesFound++;
          }
        }

    return  number;
    }
}