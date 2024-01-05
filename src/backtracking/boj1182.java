package backtracking;

import java.io.*;
import java.util.*;

public class boj1182 {
    private static int N, S;
    private static int result = 0;
    private static int[] arr;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);

        if (S == 0) {
            result--;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void func(int cur, int total) {
        if (cur == N) {
            if (total == S) {
                result++;
            }
            return;
        }
        func(cur + 1, total);
        func(cur + 1, total + arr[cur]);
    }
}
