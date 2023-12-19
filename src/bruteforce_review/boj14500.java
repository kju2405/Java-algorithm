package bruteforce_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14500 {
    private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    /*
    길쭉이 : 두가지 (회전만 하면됌)
    z모양 : 네가지 (회전 -> 대칭 -> 회전)
    ㅗ : 네가지(회전 -> 회전 -> 회전)
    네모 : 한가지
    ㄱ : 여덟가지 (회전 -> 회전 -> 회전 -> 대칭 -> 회전 -> 회전 -> 회전)

    2 + 4 + 4 + 1 + 8 = 19가지
     */
    private final static int[][][] shape = {
        {{1, 1, 1, 1}},
        {{1, 1, 0},
            {0, 1, 1}},
        {{0, 1, 0},
            {1, 1, 1}},
        {{1, 1},
            {1, 1}},
        {{1, 1, 1},
            {0, 0, 1}}
    };

    public static void main(String[] args) throws IOException {
        String line = bufferedReader.readLine();
        String[] input = line.split(" ");

        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        int[][] array = new int[row][col];
        fillArray(array);

        int maxNum = calculateTetromino(array);

        System.out.println(maxNum);
    }

    private static void fillArray(int[][] array) throws IOException {
        for (int i = 0; i < array.length; i++) {
            String line = bufferedReader.readLine();
            String[] input = line.split(" ");
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    private static int calculateTetromino(int[][] array) {
        int maxNum = 0;
        int[][] resolvingShape = shape[0];

        for (int i = 0; i < 19; i++) {
            resolvingShape = getShape(i, resolvingShape);
            int num = calculateMaxNum(resolvingShape, array);
            maxNum = Math.max(maxNum, num);
        }

        return maxNum;
    }

    private static int calculateMaxNum(int[][] resolvingShape, int[][] array) {
        int height = resolvingShape.length;
        int width = resolvingShape[0].length;

        int maxNum = 0;

        for (int i = 0; i < array.length - height + 1; i++) {
            for (int j = 0; j < array[i].length - width + 1; j++) {
                int sum = 0;
                for (int k = 0; k < height; k++) {
                    for (int a = 0; a < width; a++) {
                        sum += array[i + k][j + a] * resolvingShape[k][a];
                    }
                }
                maxNum = Math.max(maxNum, sum);
            }
        }

        return maxNum;
    }

    private static int[][] getShape(int idx, int[][] resolvingShape) {
        if (idx == 0) {
            return shape[0];
        } else if (idx == 2) {
            return shape[1];
        } else if (idx == 6) {
            return shape[2];
        } else if (idx == 10) {
            return shape[3];
        } else if (idx == 11) {
            return shape[4];
        } else if (idx == 4 || idx == 15) {
            return flip(resolvingShape);
        } else {
            return rotate(resolvingShape);
        }
    }

    private static int[][] flip(int[][] shape) {
        int height = shape.length;
        int width = shape[0].length;

        int[][] result = new int[height][width];

        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                result[i][j] = shape[i][width - 1 - j];
            }
        }

        return result;
    }

    private static int[][] rotate(int[][] shape) {
        int height = shape.length;
        int width = shape[0].length;

        int[][] returnShape = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                returnShape[i][j] = shape[height - 1 - j][i];
            }
        }

        return returnShape;
    }
}
