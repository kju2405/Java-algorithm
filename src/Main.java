import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N, S;
    private static int[] arr;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);

        if (S == 0) {
            answer--;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void backtracking(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }
        backtracking(index + 1, sum);
        backtracking(index + 1, sum + arr[index]);
    }
}