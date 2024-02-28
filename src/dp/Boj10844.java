package dp;

import java.io.*;
import java.util.*;

public class Boj10844 {
    static int N;
    static long[][] arr;
    static final long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i - 1][1] % MOD;
                } else if (j == 9) {
                    arr[i][j] = arr[i - 1][8] % MOD;
                } else {
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % MOD;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += arr[N][i];
        }

        bw.write(String.valueOf(result % MOD));

        br.close();
        bw.close();
    }
}
