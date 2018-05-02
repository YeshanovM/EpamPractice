package task4;

import java.util.Arrays;
import java.util.concurrent.*;

public class Runner {

    private static final int THREADS_COUNT = 8;
    private static final int ARRAY_LENGTH = 1_000_000;

    static class ArraySum extends RecursiveTask<Integer> {

        int[] array;

        public ArraySum(int[] array) {
            this.array = array;
        }

        @Override
        protected Integer compute() {
            if(array.length <= 20) {
                int sum = 0;
                for(int item : array)
                    sum += item;
                return sum;
            }
            else {
                ArraySum leftPart = new ArraySum(
                        Arrays.copyOf(array,array.length / 2));
                ArraySum rightPart = new ArraySum(
                        Arrays.copyOfRange(array, array.length / 2, array.length));
                leftPart.fork();
                int leftPartSum = rightPart.compute();
                return leftPart.join() + leftPartSum;
            }
        }
    }

    public void run() {
        ForkJoinPool pool = new ForkJoinPool(THREADS_COUNT);
        int[] array = generateArray();
        int sum = pool.invoke(new ArraySum(array));
        System.out.println(sum);
    }

    private int[] generateArray() {
        int[] result = new int[ARRAY_LENGTH];
        for(int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * 100);
        }
        return result;
    }
}
