package bfs_review_sec;

import java.io.*;
import java.util.*;

public class boj7576 {

    static int row, col;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        dist = new int[row][col];

        queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        bfs();

        int result = calculateResult();

        bw.write(String.valueOf(result));

        br.close();
        bw.close();

    }

    private static int calculateResult() {
        int maxNum = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maxNum < dist[i][j]) {
                    maxNum = dist[i][j];
                }

                if (dist[i][j] == 0 && board[i][j] == 0) {
                    return -1;
                }
            }
        }
        return maxNum;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }

                if (board[nx][ny] == 0 && dist[nx][ny] == 0) {
                    queue.offer(new Pair(nx, ny));
                    dist[nx][ny] = dist[cur.getX()][cur.getY()] + 1;
                }
            }
        }
    }

    static class Pair {
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
