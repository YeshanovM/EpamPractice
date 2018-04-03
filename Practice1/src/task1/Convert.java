package task1;

import java.util.*;

public class Convert {

    private static final char[] ALPHABET =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] convertByBase(int number, int base) {
        char[] result = new char[32];
        int count = 0;
        while (number != 0) {
            result[count++] = ALPHABET[number % base];
            number = (number - (number % base)) / base;
        }
        return reverse(Arrays.copyOf(result, count));
    }

    private static char[] reverse(char[] array) {
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[array.length - i - 1] = array[i];
        }
        return result;
    }
}
