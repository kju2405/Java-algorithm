package dp;

import java.io.*;
import java.util.*;

public class Boj2240 {
    static int T, W;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        dp = new int[T + 1][3][W + 1];

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            dp[1][1][0] = 1;
            dp[1][2][1] = 0;
        } else {
            dp[1][1][0] = 0;
            dp[1][2][1] = 1;
        }

        for (int i = 2; i <= T; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 1) {
                dp[i][1][0] = dp[i - 1][1][0] + 1;
                dp[i][2][0] = dp[i - 1][2][0];
                for (int j = 1; j <= W; j++) {
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][2][j - 1]) + 1;
                    dp[i][2][j] = Math.max(dp[i - 1][1][j - 1], dp[i - 1][2][j]);
                }
            } else {
                dp[i][1][0] = dp[i - 1][1][0];
                dp[i][2][0] = dp[i - 1][2][0] + 1;
                for (int j = 1; j <= W; j++) {
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][2][j - 1]);
                    dp[i][2][j] = Math.max(dp[i - 1][1][j - 1], dp[i - 1][2][j]) + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= W; i++) {
            max = Math.max(max, Math.max(dp[T][1][i], dp[T][2][i]));
        }

        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }
}
