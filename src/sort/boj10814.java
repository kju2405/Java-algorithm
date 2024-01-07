package sort;

import java.io.*;

public class boj10814 {
    static String[] arr;
    static String[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testNum = Integer.parseInt(br.readLine());

        arr = new String[testNum];
        tmp = new String[testNum];

        for (int i = 0; i < testNum; i++) {
            arr[i] = br.readLine();
        }

        mergeSort(0, testNum);

        for (int i = 0; i < testNum; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void mergeSort(int st, int en) {
        if (st == (en - 1)) {
            return;
        }

        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }

    private static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int lIdx = st;
        int rIdx = mid;
        int leftAge = 0;
        int rightAge = 0;
        for (int i = st; i < en; i++) {
            if (lIdx != mid && rIdx != en) {
                leftAge = Integer.parseInt(arr[lIdx].split(" ")[0]);
                rightAge = Integer.parseInt(arr[rIdx].split(" ")[0]);
            }
            if (lIdx == mid) {
                tmp[i] = arr[rIdx++];
            } else if (rIdx == en) {
                tmp[i] = arr[lIdx++];
            } else if (leftAge <= rightAge) {
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
