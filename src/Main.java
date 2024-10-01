import java.io.*;
import java.util.*;

public class Main {

    private static boolean[][] board;
    private static boolean[] visitedDfs;
    private static boolean[] visitedBfs;
    private static int N, M, V;

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        board = new boolean[N + 1][N + 1];
        visitedBfs = new boolean[N + 1];
        visitedDfs = new boolean[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x][y] = true;
            board[y][x] = true;
        }

        dfs(V);
        bw.newLine();
        bfs(V);

        br.close();
        bw.close();
    }

    private static void dfs(int idx) throws IOException {
        bw.write(idx + " ");
        visitedDfs[idx] = true;

        for (int i = 1; i <= N; i++) {
            if (board[idx][i] && !visitedDfs[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int idx) throws IOException {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(idx);
        visitedBfs[idx] = true;

        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            bw.write(cur + " ");
            for (int i = 1; i <= N; i++) {
                if (board[cur][i] && !visitedBfs[i]) {
                    queue.addLast(i);
                    visitedBfs[i] = true;
                }
            }
        }
    }
}