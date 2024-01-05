package backtraking_review;

import java.io.*;
import java.util.StringTokenizer;

public class boj15650 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int idx = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        func(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void func(int idx, int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            arr[depth] = i + 1;
            func(i + 1, depth + 1);
        }
    }
}
