package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class boj16173 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        //board, visited 선언
        board = new int[N][N];
        visited = new boolean[N][N];

        //board 초기화
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dfs
        dfs(0, 0);

        //결과 출력
        if (visited[N - 1][N - 1]) {
            bw.write("HaruHaru");
        } else {
            bw.write("Hing");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        int num = board[x][y];
        if (num == -1) {
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i] * num;
            int ny = y + dy[i] * num;

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (!visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
