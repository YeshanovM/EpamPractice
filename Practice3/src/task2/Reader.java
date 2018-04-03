package task2;

import java.util.*;

public class Reader {
    public static int[] readCarriagesOrder() {
        System.out.print("1 - coupe carriage\n" +
                "2 - economic class carriage\n" +
                "3 - intercity carriage\n" +
                "4 - luxury carriage\n" +
                "5 - restaurant carriage\n" +
                "Input carriages order: ");
        String[] order;
        boolean isCorrect;
        Scanner sc = new Scanner(System.in);
        do {
            isCorrect = true;
            order = sc.nextLine().split(" +");
            for(String item : order) {
                isCorrect = isCorrect && item.matches("[1-5]");
            }
            if(!isCorrect)
                System.out.print("Incorrect input. Please, reinput: ");
        } while(!isCorrect);
        int[] result = new int[order.length];
        for(int i = 0; i < order.length; i++)
            result[i] = Integer.parseInt(order[i]);
        return result;
    }

    public static int readTrainNumber() {
        System.out.print("Input train number: ");
        boolean isCorrect;
        int result = -1;
        Scanner sc = new Scanner(System.in);
        do {
            String input = sc.nextLine();
            if(input.matches("[0-9]{1,6}")) {
                result = Integer.parseInt(input);
                isCorrect = true;
            }
            else {
                isCorrect = false;
                System.out.print("Incorrect input. Please, reinput: ");
            }
        } while(!isCorrect);
        return result;
    }
}
