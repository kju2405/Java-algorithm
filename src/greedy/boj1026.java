package greedy;

import java.io.*;
import java.util.*;

public class boj1026 {
    static int N;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Integer[] arrayB = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(arrayB, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i] * arrayB[i];
        }

        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}


/*
0 1 1 1 6
8 7 3 2 1
0 7 3 2 6
 */