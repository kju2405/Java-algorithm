package bruteforce;

import java.io.*;

public class boj3085 {

    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //N 입력받음
        int N = Integer.parseInt(bufferedReader.readLine());

        //크기가 N인 이차원 배열 만들고 요소 넣기
        char[][] array = new char[N][N];

        fillArray(N, bufferedReader, array);

        //행, 열 하나씩 바꿔가며 최대 숫자 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1, array);
                checkMaxCandyNum(array);
                swap(i, j, i, j + 1, array);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j, array);
                checkMaxCandyNum(array);
                swap(i, j, i + 1, j, array);
            }
        }

        //최대 숫자 출력
        System.out.println(max);
    }

    private static void swap(int fromY, int fromX, int toY, int toX, char[][] array) {
        char temp = array[fromY][fromX];
        array[fromY][fromX] = array[toY][toX];
        array[toY][toX] = temp;
    }

    private static void checkMaxCandyNum(char[][] array) {
        //행을 기준으로 계산
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] == array[i][j + 1]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        //열을 기준으로 계산
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[j][i] == array[j + 1][i]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }
    }

    private static void fillArray(int N, BufferedReader bufferedReader, char[][] array) throws IOException {
        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();

            for (int j = 0; j < N; j++) {
                array[i][j] = line.charAt(j);
            }
        }
    }
}
