package search;

import java.io.*;
import java.util.*;

public class Boj1920 {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isExist(num)) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static boolean isExist(int num) {
        int st = 0;
        int en = A.length - 1;

        while (st <= en) {
            int mid = (st + en) / 2;

            if (A[mid] == num) {
                return true;
            }

            if (num > A[mid]) {
                st = mid + 1;
            }

            if (num < A[mid]) {
                en = mid - 1;
            }
        }
        return false;
    }
}
