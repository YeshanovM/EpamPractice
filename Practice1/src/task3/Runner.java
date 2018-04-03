package task3;

public class Runner {
    public static void run(String[] args) {
        try {
            int number = Integer.parseInt(args[0]);
            if (number < 1 || number > 9) {
                System.out.println("Only positive numbers less than or equal to 9 allowed!");
                return;
            }
            char[][] pyramid = Pyramid.getPyramid(number);
            for (int i = 0; i < pyramid.length; i++) {
                for (int j = 0; j < pyramid[i].length; j++) {
                    System.out.print(pyramid[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
