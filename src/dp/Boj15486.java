package dp;

import java.io.*;
import java.util.*;

public class Boj15486 {
    static int N;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][2];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            //일을 못하는 경우
            if (i + arr[i][0] > N + 1) {
                dp[i] = dp[i + 1];
            }
            //일을 할 수 있는 경우
            else {
                dp[i] = arr[i][1];
                dp[i] = Math.max(dp[i + 1], dp[i] + dp[i + arr[i][0]]);
            }
        }

        bw.write(String.valueOf(dp[1]));
        br.close();
        bw.close();
    }
}
