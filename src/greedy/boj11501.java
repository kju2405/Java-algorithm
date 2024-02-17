package greedy;

import java.io.*;
import java.util.*;

public class boj11501 {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int N = Integer.parseInt(br.readLine());

            arr = new long[N];
            long answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long maxPrice = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (maxPrice < arr[i]) {
                    maxPrice = arr[i];
                } else {
                    answer += (maxPrice - arr[i]);
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
