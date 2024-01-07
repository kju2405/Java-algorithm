package sort;

import java.io.*;
import java.util.*;

public class merge_sort_test {
    private static int n = 10;
    private static int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
    private static int[] tmp = new int[n];
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        merge_sort(0, n);
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
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

    private static void merge_sort(int st, int en) {
        if (st == (en - 1)) return; // 길이 1인 경우
        int mid = (st + en) / 2;
        merge_sort(st, mid); // arr[st:mid]을 정렬한다.
        merge_sort(mid, en); // arr[mid:en]을 정렬한다.
        merge(st, en); // arr[st:mid]와 arr[mid:en]을 합친다.
    }
}
