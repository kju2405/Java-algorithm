package dp;

import java.io.*;
import java.util.*;

public class Boj2748 {
    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write(String.valueOf(1));
            br.close();
            bw.close();
            System.exit(0);
        }

        dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        bw.write(String.valueOf(dp[N]));
        br.close();
        bw.close();
    }
}
