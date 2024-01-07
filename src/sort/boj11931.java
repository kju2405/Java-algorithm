package sort;

import java.io.*;

public class boj11931 {
    private static int N;
    private static int[] arr;
    private static int[] tmp;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort_reverse(0, N);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void merge_sort_reverse(int st, int en) {
        if (st == (en - 1)) {
            return;
        }

        int mid = (st + en) / 2;
        merge_sort_reverse(st, mid);
        merge_sort_reverse(mid, en);
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
                tmp[i] = arr[rIdx++];
            } else {
                tmp[i] = arr[lIdx++];
            }
        }
        for (int i = st; i < en; i++) {
            arr[i] = tmp[i];
        }
    }
}
