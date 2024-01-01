package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15654 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int[] arr;
    private static int[] inputNums;
    private static boolean[] isUsed;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        inputNums = new int[N];
        isUsed = new boolean[N];

        initInputNums();


        Arrays.sort(inputNums);

        func(0);

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
                arr[depth] = inputNums[i];
                isUsed[i] = true;
                func(depth + 1);
                isUsed[i] = false;
            }
        }
    }
}
