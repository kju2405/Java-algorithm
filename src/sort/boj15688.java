package sort;

import java.io.*;

public class boj15688 {
    private static int[] arr = new int[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(br.readLine());
            idx += 1000000;
            arr[idx]++;
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = 0; j < num; j++) {
                bw.write(i - 1000000 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
