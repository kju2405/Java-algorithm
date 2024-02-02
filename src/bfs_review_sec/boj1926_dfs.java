package bfs_review_sec;

import java.io.*;
import java.util.*;

public class boj1926_dfs {
    static int[][] board;
    static boolean[][] visited;
    static int row, col;
    static int picNum, picMaxSize, picSize;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dfs
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    picSize = 0;
                    dfs(i, j);
                    picNum++;
                }
            }
        }

        //결과 출력
        bw.write(String.valueOf(picNum));
        bw.newLine();
        bw.write(String.valueOf(picMaxSize));

        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        picSize++;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                continue;
            }

            if (board[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }

        picMaxSize = Math.max(picMaxSize, picSize);
    }
}
