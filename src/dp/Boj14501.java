package dp;

import java.io.*;
import java.util.*;

public class Boj14501 {
    static int N;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][2];
        dp = new int[N + 2];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[i][0] = t;
            arr[i][1] = p;
        }

        for (int i = N; i > 0; i--) {
            int next = i + arr[i][0];
            if (next > N + 1) { //일 못해
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(arr[i][1] + dp[next], dp[i + 1]);
            }
        }

        bw.write(String.valueOf(dp[1]));

        br.close();
        bw.close();

    }
}


/*
10
5 50
4 40
3 30
2 20
1 10 50
1 10 60
2 20 60
3 30 80
4 40
5 50
 */