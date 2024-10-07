import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static boolean[] isused;

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isused = new boolean[N + 1];

        func(0);

        br.close();
        bw.close();
    }

    private static void func(int idx) throws IOException {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isused[i]) {
                isused[i] = true;
                arr[idx] = i;
                func(idx + 1);
                isused[i] = false;
            }
        }
    }
}