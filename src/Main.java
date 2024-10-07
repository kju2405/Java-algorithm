import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static boolean[] isused;
    private static int N, M;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isused = new boolean[N + 1];

        backtracking(0, 1);

        br.close();
        bw.close();
    }

    private static void backtracking(int idx, int from) throws IOException {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = from; i <= N; i++) {
            if (!isused[i]) {
                isused[i] = true;
                arr[idx] = i;
                backtracking(idx + 1, i + 1);
                isused[i] = false;
            }
        }
    }
}