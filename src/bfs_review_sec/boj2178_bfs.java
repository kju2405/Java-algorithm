package bfs_review_sec;

import java.io.*;
import java.util.*;

public class boj2178_bfs {
    static int[][] board;
    static int[][] dist;
    static int row, col;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        dist = new int[row][col];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        queue = new LinkedList<>();
        bfs();

        int result = dist[row - 1][col - 1];

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private static void bfs() {
        queue.offer(new Pair(0, 0));
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }

                if (board[nx][ny] == 1 && dist[nx][ny] == 0) {
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
