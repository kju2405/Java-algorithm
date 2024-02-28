import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[1000001];

        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MAX_VALUE;
            int num3 = Integer.MAX_VALUE;

            if (i % 2 == 0) {
                num1 = dp[i / 2] + 1;
            }

            if (i % 3 == 0) {
                num2 = dp[i / 3] + 1;
            }

            num3 = dp[i - 1] + 1;

            dp[i] = Math.min(Math.min(num1, num2), num3);
        }

        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.close();
    }
}