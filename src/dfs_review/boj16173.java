package dfs_review;

import java.io.*;
import java.util.StringTokenizer;

public class boj16173 {
    static int[][] board;
    static boolean[][] visited;
    static int N;
    private static final String WIN = "HaruHaru";
    private static final String LOSE = "Hing";
    static boolean canGo = false;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        if (canGo) {
            bw.write(WIN);
        } else {
            bw.write(LOSE);
        }

        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int curNum = board[x][y];

        if (curNum == -1) {
            canGo = true;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i] * curNum;
            int ny = y + dy[i] * curNum;

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (!visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
