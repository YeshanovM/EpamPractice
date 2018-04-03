package task4;

public class MatrixTurn {

    public static int[][] generateMatrix(int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = (int) (Math.random() * 100) - 50;
            }
        }
        return result;
    }

    public static int[][] turnMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = matrix[j][matrix.length - i - 1];
            }
        }
        return result;
    }
}
