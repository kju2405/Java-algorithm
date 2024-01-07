package sort;

import java.io.*;
import java.util.*;

public class boj2750 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int numCnt;
    private static int[] arr;
    private static int[] tmp;

    public static void main(String[] args) throws IOException {
        numCnt = Integer.parseInt(br.readLine());

        arr = new int[numCnt];
        tmp = new int[numCnt];

        for (int i = 0; i < numCnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(0, numCnt);
        for (int i = 0; i < numCnt; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void merge_sort(int st, int en) {
        if (st == (en - 1)) {
            return;
        }

        int mid = (st + en) / 2;
        merge_sort(st, mid);
        merge_sort(mid, en);
        merge(st, en);
    }

    private static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int lIdx = st;
        int rIdx = mid;
        for (int i = st; i < en; i++) {
            if (lIdx == mid) {
                tmp[i] = arr[rIdx++];
            } else if (rIdx == en) {
                tmp[i] = arr[lIdx++];
            } else if (arr[lIdx] <= arr[rIdx]) {
                tmp[i] = arr[lIdx++];
            } else {
                tmp[i] = arr[rIdx++];
            }
        }

        for (int i = st; i < en; i++) {
            arr[i] = tmp[i];
        }
    }
}
