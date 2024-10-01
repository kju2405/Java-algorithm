import java.io.*;
import java.util.*;

public class Main {

    private static boolean[][] board;
    private static boolean[] visited;
    private static int from, to;
    private static int n, k;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        board = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x][y] = true;
            board[y][x] = true;
        }

        dfs(from, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void dfs(int idx, int cnt) {
        visited[idx] = true;

        if (idx == to) {
            answer = cnt;
        }

        if (visited[to]) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (board[idx][i] && !visited[i]) {
                dfs(i, cnt + 1);
            }
        }

        visited[idx] = false;
    }
}