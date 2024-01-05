package backtraking_review;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15654 {
    private static int N, M;
    private static int[] arr;
    private static int[] inputNum;
    private static boolean[] isUsed;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        inputNum = new int[N];
        isUsed = new boolean[N];

        initInputNum();

        sortInputNum();

        func(0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initInputNum() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            inputNum[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void sortInputNum() {
        Arrays.sort(inputNum);
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
            if (!isUsed[i]) {
                arr[depth] = inputNum[i];
                isUsed[i] = true;
                func(depth + 1);
                isUsed[i] = false;
            }
        }
    }
}
