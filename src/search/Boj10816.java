package search;

import java.io.*;
import java.util.*;

public class Boj10816 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            int lIdx = findLidx(num);
            int rIdx = findRidx(num);

            System.out.println("lIdx = " + lIdx);
            System.out.println("rIdx = " + rIdx);

            bw.write((rIdx - lIdx) + " ");
        }

        br.close();
        bw.close();
    }

    private static int findLidx(int num) {
        int st = 0;
        int en = N;

        while (st < en) {
            int mid = (st + en) / 2;

            if (num <= arr[mid]) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    private static int findRidx(int num) {
        int st = 0;
        int en = N;

        while (st < en) {
            int mid = (st + en) / 2;

            if (num < arr[mid]) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }

        return en;
    }
}