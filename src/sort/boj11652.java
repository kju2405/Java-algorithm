package sort;

import java.io.*;
import java.util.Arrays;

public class boj11652 {
    private static long[] arr;
    private static long cnt, maxCnt;
    private static long maxVal = -(1 << 62) - 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (i == 0 || arr[i] == arr[i - 1]) {
                cnt++;
            } else {
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    maxVal = arr[i - 1];
                }
                cnt = 1;
            }
        }

        if (cnt > maxCnt) {
            maxVal = arr[arr.length - 1];
        }

        bw.write(maxVal + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
