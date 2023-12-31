import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter implements Runnable {
    private int value = 0;
    private Integer i = 10;
    private Lock l = new ReentrantLock();

    public void increment() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value++;
    }


    public void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }

    public void run() {
        // get a lock
        //  synchronized (this) {
        l.lock();
        try {
            this.increment();
            System.out.println(Thread.currentThread().getName() + " increments: " + this.getValue());
            this.decrement();
            System.out.println(Thread.currentThread().getName() + " decrements: " + this.getValue());
        } finally {
            l.unlock();
        }
        // }
        //release a lock
    }
}


public class F_synchronized {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(counter, "one").start();
        new Thread(counter, "two").start();
        new Thread(counter, "Three").start();
        new Thread(counter, "Four").start();

        Counter counter2 = new Counter();
        new Thread(counter2, "Counter 2").start();
    }
}
