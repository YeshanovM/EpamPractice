package task4;

public class Runner {
    public static void run(String[] args) {
        try {
            int number = Integer.parseInt(args[0]);
            if (number < 1) {
                System.out.println("Only positive numbers allowed!");
                return;
            }
            System.out.println("Generated matrix:");
            int[][] generatedMatrix = MatrixTurn.generateMatrix(number);
            printArray(generatedMatrix);
            System.out.println("Turned matrix:");
            int[][] turnedMatrix = MatrixTurn.turnMatrix(generatedMatrix);
            printArray(turnedMatrix);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
