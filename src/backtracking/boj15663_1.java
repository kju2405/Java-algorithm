package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class boj15663_1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[] arr;
    private static int[] inputNums;
    private static boolean[] visit;
    private static LinkedHashSet<String> linkedHashSet;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        inputNums = new int[N];
        visit = new boolean[N];

        linkedHashSet = new LinkedHashSet<>();

        initInputNums();
        Arrays.sort(inputNums);

        func(0);

        printResult();

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

    private static void func(int depth) throws IOException {
        if (depth == M) {
            sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            linkedHashSet.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                arr[depth] = inputNums[i];
                visit[i] = true;
                func(depth + 1);
                visit[i] = false;
            }
        }
    }

    private static void printResult() throws IOException{
        for (String element : linkedHashSet) {
            bw.write(element + "\n");
        }
    }
}
