package task2.subtask1;

import java.util.*;

public class CollectionGenerator {

    public static List<Integer> generateList(int length, int min, int max) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < length; i++) {
            list.add(generateNumber(min, max));
        }
        return list;
    }

    public static Set<Integer> generateSet(int length, int min, int max) {
        if(max - min + 1 < length)
            return null;
        Set<Integer> set = new TreeSet<>();
        while(set.size() < length) {
            set.add(generateNumber(min, max));
        }
        return set;
    }

    private static int generateNumber(int min, int max) {
        int result = (int)(Math.random() * (max - min + 1));
        result += min;
        return result;
    }
}
