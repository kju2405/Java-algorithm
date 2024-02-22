package greedy;

import java.io.*;
import java.util.*;

public class Boj2847 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                continue;
            }

            answer += (arr[i] - arr[i + 1] + 1);
            arr[i] = arr[i + 1] - 1;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
