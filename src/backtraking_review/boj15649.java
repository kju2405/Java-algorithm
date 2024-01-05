package backtraking_review;

import java.io.*;
import java.util.StringTokenizer;

public class boj15649 {
    private static int[] arr;
    private static boolean[] isUsed;
    private static int N, M;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isUsed = new boolean[N];

        func(0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void func(int depth) throws IOException{
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                arr[depth] = i + 1;
                isUsed[i] = true;
                func(depth + 1);
                isUsed[i] = false;
            }
        }
    }
}
