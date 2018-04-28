package task3;

import java.util.Arrays;

public class Runner {
    public static void run() {
        operateInts();
        operateStrings();
    }

    public static void operateInts() {
        Integer[] array = new Integer[10];
        for(int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 50);
        }
        System.out.println("Before: " + Arrays.toString(array));
        Arrays.sort(array, (a, b) -> Integer.compare(b, a));
        System.out.println("After: " + Arrays.toString(array));
    }

    public static void operateStrings() {
        String[] array = new String[] {
                "string 1",
                "string 2",
                "abcde",
        };
        System.out.println("Before: " + Arrays.toString(array));
        Arrays.sort(array, (a, b) -> b.compareTo(a));
        System.out.println("Before: " + Arrays.toString(array));
    }
}
