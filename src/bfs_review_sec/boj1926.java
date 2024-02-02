package bfs_review_sec;

import java.io.*;
import java.util.*;

public class boj1926 {
    static int[][] board;
    static boolean[][] visited;
    static int row, col;
    static int picNum, picMaxSize;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        //board, visited 선언
        board = new int[row][col];
        visited = new boolean[row][col];

        //board 초기화
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //bfs
        queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
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

    private static void bfs(int x, int y) {
        queue.offer(new Pair(x, y));
        visited[x][y] = true;

        int picSize = 0;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            picSize++;

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }

                if (board[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        if (picMaxSize < picSize) {
            picMaxSize = picSize;
        }
    }

    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }
}
