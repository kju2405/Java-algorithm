package dp;

import java.io.*;

public class boj11726 {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write(String.valueOf(1));
            bw.close();
            br.close();

            System.exit(0);
        }

        arr = new long[n];

        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        bw.write(String.valueOf(arr[n - 1]));

        br.close();
        bw.close();
    }
}
