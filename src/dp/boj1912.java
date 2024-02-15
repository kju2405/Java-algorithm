package dp;

import java.io.*;
import java.util.*;

public class boj1912 {
    static int N;
    static int[] inputNums;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        inputNums = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputNums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = inputNums[0];

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + inputNums[i], inputNums[i]);

            max = Math.max(dp[i], max);
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}