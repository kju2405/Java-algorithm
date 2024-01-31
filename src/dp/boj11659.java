package dp;

import java.io.*;
import java.util.StringTokenizer;

public class boj11659 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //arr선언 및 초기화
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //arr합구하기
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        //결과 출력
        int j, k;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(arr[k] - arr[j - 1]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
