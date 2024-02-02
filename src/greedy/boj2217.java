package greedy;

import java.io.*;
import java.util.*;

public class boj2217 {
    static int N;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            result[i] = arr[i] * (N - i);
        }

        Arrays.sort(result);

        bw.write(String.valueOf(result[N-1]));

        br.close();
        bw.close();
    }
}
