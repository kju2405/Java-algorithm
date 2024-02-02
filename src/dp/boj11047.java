package dp;

import java.io.*;
import java.util.*;

public class boj11047 {
    static int N, K;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (K >= arr[i]) {
                answer += K / arr[i];
                K = K % arr[i];
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
