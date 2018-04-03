package task3;

public class Pyramid {
    public static char[][] getPyramid(int height) {
        int width = height * 2 + 1;
        char[][] result = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                result[i][j] = ' ';
                result[i][width - j - 1] = ' ';
            }
            for (int j = 1; j <= i + 1; j++) {
                result[i][height - i - 1 + j] = (char) (j + '0');
                result[i][width - (height - i - 1 + j) - 1] = (char) (j + '0');
            }
        }
        return result;
    }
}
