import java.util.concurrent.*;

public class Callable_Example {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed form of Runnable");
            }
        };

        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Printed from Callable");
                Thread.sleep(2000);
                return "Value from Callable";
            }
        };


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(c);
        String retStr = submit.get();
        System.out.println(retStr);

    }
}
