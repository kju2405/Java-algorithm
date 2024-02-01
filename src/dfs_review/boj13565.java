package dfs_review;

import java.io.*;
import java.util.StringTokenizer;

public class boj13565 {
    static int[][] board;
    static boolean[][] visited;
    static int row, col;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        //graph, visited 선언
        board = new int[row][col];
        visited = new boolean[row][col];

        //graph 초기화
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        //dfs
        for (int i = 0; i < col; i++) {
            if (!visited[0][i]) {
                dfs(0, i);
            }
        }

        //결과  출력
        boolean flag = false;
        for (int i = 0; i < col; i++) {
            if (visited[row - 1][i]) {
                flag = true;
                break;
            }
        }

        if (flag) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.close();
        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                continue;
            }

            if (board[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
