package backtraking_review;

import java.io.*;
import java.util.*;

public class boj15655 {
    private static int N, M;
    private static int[] arr;
    private static int[] inputNums;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        inputNums = new int[N];

        initInputNums();
        sortInputNums();

        func(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initInputNums() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            inputNums[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void sortInputNums() {
        Arrays.sort(inputNums);
    }

    private static void func(int start, int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = inputNums[i];
            func(i + 1, depth + 1);
        }
    }
}
