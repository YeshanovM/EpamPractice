package task1;

public class Runner {
    public static void run(String[] args) {
        try {
            int number = Integer.parseInt(args[0]);
            if (number < 1) {
                System.out.println("Only positive integers allowed!");
                return;
            }
            System.out.println("Dec: " + number);
            System.out.print("Bin: ");
            printArray(Convert.convertByBase(number, 2));
            System.out.print("Oct: ");
            printArray(Convert.convertByBase(number, 8));
            System.out.print("Hex: ");
            printArray(Convert.convertByBase(number, 16));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static void printArray(char[] array) {
        for (char item : array) {
            System.out.print(item);
        }
        System.out.println();
    }
}
