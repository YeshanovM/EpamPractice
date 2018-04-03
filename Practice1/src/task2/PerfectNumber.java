package task2;

import java.util.*;

public class PerfectNumber {
    public static int[] getPerfectNumbers(int max) {
        int[] result = new int[5];
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (isPerfectNumber(i)) {
                result[count] = i;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public static boolean isPerfectNumber(int number) {
        int[] dividers = getDividers(number);
        int sum = -number;
        for (int divider : dividers) {
            sum += divider;
            if (sum > number)
                return false;
        }
        return sum == number;
    }

    public static int[] getDividers(int number) {
        int[] result = new int[number];
        int count = 0;
        for (int i = 1; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                result[count] = i;
                count++;
                if (number / i != i) {
                    result[count] = number / i;
                    count++;
                }
            }
        }
        return Arrays.copyOf(result, count);
    }
}
