package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public void run() {

    }

    public List<Integer> arrayToList(int[] array) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int element : array) {
            result.add(element);
        }
        return result;
    }
}
