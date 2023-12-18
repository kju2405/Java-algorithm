package bruteforce_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3085 {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int maxNum = 0;

    public static void main(String[] args) throws IOException {

        //N입력
        int N = Integer.parseInt(bufferedReader.readLine());

        //배열 채우기
        char[][] bomboni = new char[N][N];
        fillBomboni(bomboni, N);

        //maxNum 계산
        //행을 기준으로 바꾸기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1, bomboni);
                checkMaxNum(bomboni);
                swap(i, j, i, j + 1, bomboni);
            }
        }

        //열을 기준으로 바꾸기
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j, bomboni);
                checkMaxNum(bomboni);
                swap(i, j, i + 1, j, bomboni);
            }
        }

        //maxNum출력
        System.out.println(maxNum);
    }

    private static void fillBomboni(char[][] bomboni, int N) throws IOException {
        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                bomboni[i][j] = line.charAt(j);
            }
        }
    }

    private static void swap(int fromY, int fromX, int toY, int toX, char[][] bomboni) {
        char tmp = bomboni[fromY][fromX];
        bomboni[fromY][fromX] = bomboni[toY][toX];
        bomboni[toY][toX] = tmp;
    }

    private static void checkMaxNum(char[][] bomboni) {
        //행 기준
        for (int i = 0; i < bomboni.length; i++) {
            int cnt = 1;
            for (int j = 0; j < bomboni[i].length - 1; j++) {
                if (bomboni[i][j] == bomboni[i][j + 1]) {
                    cnt++;
                    maxNum = Math.max(maxNum, cnt);
                } else {
                    cnt = 1;
                }
            }
        }

        //열 기준
        for (int i = 0; i < bomboni.length; i++) {
            int cnt = 1;
            for (int j = 0; j < bomboni[i].length - 1; j++) {
                if (bomboni[j][i] == bomboni[j + 1][i]) {
                    cnt++;
                    maxNum = Math.max(maxNum, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }
}
