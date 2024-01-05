package backtraking_review;

import java.io.*;
import java.util.StringTokenizer;

public class boj15651 {
    private static int N, M;
    private static int[] arr;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        func(0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void func(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            func(depth + 1);
        }
    }
}
