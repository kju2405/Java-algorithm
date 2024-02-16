package dp;

import java.io.*;
import java.util.*;

public class boj11055 {
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

        for (int i = 0; i < N; i++) {
            dp[i] = inputNums[i]; // 각 원소를 포함하는 부분 수열의 최소 합은 원소 자체입니다.
            for (int j = 0; j < i; j++) {
                if (inputNums[i] > inputNums[j]) { // 증가하는 부분을 찾습니다.
                    dp[i] = Math.max(dp[i], dp[j] + inputNums[i]); // 최대 합을 갱신합니다.
                }
            }
        }


        int result = 0;
        for (int val : dp) {
            result = Math.max(result, val);
        }

        bw.write(String.valueOf(result));

        bw.close();
        br.close();
    }
}
