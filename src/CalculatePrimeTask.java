import java.util.concurrent.RecursiveTask;

public class CalculatePrimeTask extends RecursiveTask<Integer> {
    int array[];
    int start;
    int end;

    public CalculatePrimeTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (start == end) {
            return PrimeNumberUtil.calculate(array[start]);
        }
        if (end - start == 1) {
            return PrimeNumberUtil.calculate(array[start] + PrimeNumberUtil.calculate(array[end]));
        }
        int mid = (start + end) / 2;
        CalculatePrimeTask subtask1 = new CalculatePrimeTask(array, start, mid);
        CalculatePrimeTask subtask2 = new CalculatePrimeTask(array, mid + 1, end);
        invokeAll(subtask1, subtask2);
        return subtask1.join() + subtask2.join();
    }
}
