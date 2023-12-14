package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14500 {
    private static int[][] shape1 = {
        {1, 1},
        {1, 1}
    };
    private static int[][] shape2 = {
        {1, 1, 1, 1}
    };
    private static int[][] shape3 = {
        {1, 1, 1},
        {0, 1, 0}
    };
    private static int[][] shape4 = {
        {1, 1, 0},
        {0, 1, 1}
    };
    private static int[][] shape5 = {
        {1, 1, 1},
        {0, 0, 1}
    };
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String inputSize = bufferedReader.readLine();
        String[] sizes = inputSize.split(" ");
        int N = Integer.parseInt(sizes[0]);
        int M = Integer.parseInt(sizes[1]);

        int[][] tetromino = new int[N][M];
        fillTetromino(tetromino);

        int maxNum = countMaxNum(tetromino);

        System.out.println(maxNum);
    }

    private static int countMaxNum(int[][] tetromino) {
        int maxNum = 0;

        //사각형 계산
        maxNum = countMaxNumByShape(maxNum, shape1, tetromino);

        //길쭉이 계산
        maxNum = countMaxNumByShape(maxNum, shape2, tetromino);
        int[][] rotatedShape = rotate(shape2);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);

        //ㅗ계산
        maxNum = countMaxNumByShape(maxNum, shape3, tetromino);
        rotatedShape = rotate(shape3);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);
        rotatedShape = rotate(rotatedShape);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);
        rotatedShape = rotate(rotatedShape);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);

        //z계산
        maxNum = countMaxNumByShape(maxNum, shape4, tetromino);
        rotatedShape = rotate(shape4);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);
        int[][] flippedShape = flip(rotatedShape);
        maxNum = countMaxNumByShape(maxNum, flippedShape, tetromino);
        rotatedShape = rotate(flippedShape);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);

        //ㄱ계산
        maxNum = countMaxNumByShape(maxNum, shape5, tetromino);
        rotatedShape = rotate(shape5);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);
        rotatedShape = rotate(rotatedShape);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);
        rotatedShape = rotate(rotatedShape);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);
        flippedShape = flip(rotatedShape);
        maxNum = countMaxNumByShape(maxNum, flippedShape, tetromino);
        rotatedShape = rotate(flippedShape);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);
        rotatedShape = rotate(rotatedShape);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);
        rotatedShape = rotate(rotatedShape);
        maxNum = countMaxNumByShape(maxNum, rotatedShape, tetromino);

        return maxNum;
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
        int[][] result = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                result[i][j] = shape[height - 1 - j][i];
            }
        }
        return result;
    }

    private static int countMaxNumByShape(int maxNum, int[][] shape, int[][] tetromino) {
        int height = shape.length;
        int width = shape[0].length;

        for (int i = 0; i <= tetromino.length - height; i++) {
            for (int j = 0; j <= tetromino[i].length - width; j++) {
                int sum = 0;
                for (int a = 0; a < height; a++) {
                    for (int b = 0; b < width; b++) {
                        sum += tetromino[i + a][j + b] * shape[a][b];
                    }
                }
                maxNum = Math.max(maxNum, sum);
            }
        }

        return maxNum;
    }

    private static void fillTetromino(int[][] tetromino) throws IOException {
        for (int i = 0; i < tetromino.length; i++) {
            String line = bufferedReader.readLine();
            String[] nums = line.split(" ");
            for (int j = 0; j < tetromino[0].length; j++) {
                tetromino[i][j] = Integer.parseInt(nums[j]);
            }
        }
    }
}
