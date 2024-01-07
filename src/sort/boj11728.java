package sort;

import java.io.*;
import java.util.*;

public class boj11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];
        int[] result = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int aIdx = 0;
        int bIdx = 0;
        for (int i = 0; i < N + M; i++) {
            if (aIdx == N) {
                result[i] = B[bIdx++];
                bw.write(result[i]+" ");
                continue;
            }

            if (bIdx == M) {
                result[i] = A[aIdx++];
                bw.write(result[i]+" ");
                continue;
            }

            if (A[aIdx] < B[bIdx]) {
                result[i] = A[aIdx];
                aIdx++;
            } else {
                result[i] = B[bIdx];
                bIdx++;
            }
            bw.write(result[i]+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
