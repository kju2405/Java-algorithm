import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] dp;
    static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];

        //초기화
        dp[1][0] = 0;
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        dp();


        //결과 출력
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
        }

        bw.write(String.valueOf(answer % MOD));

        br.close();
        bw.close();
    }

    private static void dp() {
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }
    }
}