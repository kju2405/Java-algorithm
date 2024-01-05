package backtraking_review;

import java.io.*;
import java.util.*;

public class boj15663 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] arr;
    private static int[] inputNums;
    private static boolean[] isUsed;
    private static int N, M;
    private static Set<String> resultSet = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        inputNums = new int[N];
        isUsed = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputNums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputNums);

        func(0);

        for (String element : resultSet) {
            bw.write(element+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void func(int depth) throws IOException {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            resultSet.add(sb.toString());
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
