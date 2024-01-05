package backtracking;

import java.io.*;
import java.util.*;

public class boj9663 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int result = 0;

    private static boolean[] isused1;
    private static boolean[] isused2;
    private static boolean[] isused3;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        isused1 = new boolean[N];
        isused2 = new boolean[2 * N - 1];
        isused3 = new boolean[2 * N - 1];

        func(0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void func(int cur) {
        if (cur == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isused1[i] || isused2[i + cur] || isused3[i - cur + N - 1]) {
                continue;
            }
            isused1[i] = true;
            isused2[i + cur] = true;
            isused3[i - cur + N - 1] = true;
            func(cur + 1);
            isused1[i] = false;
            isused2[i + cur] = false;
            isused3[i - cur + N - 1] = false;
        }
    }
}
