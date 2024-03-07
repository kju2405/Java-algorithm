import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] board;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        board = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            board[from][to] = true;
            board[to][from] = true;
        }

        dfs(1);

        bw.write(String.valueOf(answer - 1));

        br.close();
        bw.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        answer++;

        for (int i = 1; i <= N; i++) {
            if (board[idx][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}