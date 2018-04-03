package task2;

import java.util.*;

public class Runner {
    public static void run(String[] args) {
        try {
            int number = Integer.parseInt(args[0]);
            if (number < 1) {
                System.out.println("Only positive integers allowed!");
                return;
            }
            System.out.println("Perfect numbers: " +
                    Arrays.toString(PerfectNumber.getPerfectNumbers(number)));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
