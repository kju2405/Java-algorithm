package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class boj15650 {
    private static int N, M;
    private static int[] arr;

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        func(1, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void func(int at, int k) throws IOException {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[k] = i;
            func(i + 1, k + 1);
        }
    }
}
