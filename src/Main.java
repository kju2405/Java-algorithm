import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] result;
    static boolean[] isUsed;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            arr = new int[N];
            result = new int[6];
            isUsed = new boolean[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            func(0, 0);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void func(int idx, int start) throws IOException {
        if (idx == result.length) {
            for (int i = 0; i < result.length; i++) {
                bw.write(result[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!isUsed[i]) {
                result[idx] = arr[i];
                isUsed[i] = true;
                func(idx + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
}