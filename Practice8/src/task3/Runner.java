package task3;

import java.util.*;
import java.util.function.*;

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
        System.out.println("Even: " + Arrays.toString(filter(array, x -> x % 2 == 0)));
    }

    public static void operateStrings() {
        String[] array = new String[] {
                "string 1",
                "string 2",
                "abcde",
        };
        System.out.println("Before: " + Arrays.toString(array));
        Arrays.sort(array, (a, b) -> b.compareTo(a));
        System.out.println("After: " + Arrays.toString(array));
        List<String> list = filter(Arrays.asList(array), s -> s.charAt(0) == 's');
        System.out.println("Strings which starts with \"s\": " + list);
    }

    public static <T> T[] filter(T[] array, Predicate<T> predicate) {
        ArrayList<T> result = new ArrayList<>();
        for(T item : array) {
            if(predicate.test(item))
                result.add(item);
        }
        return (T[]) result.toArray();
    }

    public static List<String> filter(List<String> strs, Predicate<String> predicate) {
        ArrayList<String> result = new ArrayList<>();
        for(String item : strs) {
            if(predicate.test(item))
                result.add(item);
        }
        return result;
    }
}
