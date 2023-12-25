package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2178 {
    private static int[][] board;
    private static int[][] dist;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        String line = br.readLine();
        String[] rowColArray = line.split(" ");

        int row = Integer.parseInt(rowColArray[0]);
        int col = Integer.parseInt(rowColArray[1]);

        board = new int[row][col];
        dist = new int[row][col];

        initDist();

        initBoard();

        calculateDist();

        System.out.println(dist[row - 1][col - 1]);
    }

    private static void initDist() {
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                dist[i][j] = -1;
            }
        }
    }

    private static void initBoard() throws IOException {
        for (int i = 0; i < board.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
    }

    private static void calculateDist() {
        dist[0][0] = 1;
        queue.offer(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int idx = 0; idx < 4; idx++) {
                int nx = cur.getX() + dx[idx];
                int ny = cur.getY() + dy[idx];

                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                    continue;
                }

                if (board[nx][ny] == 0 || dist[nx][ny] != -1) {
                    continue;
                }

                queue.offer(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.getX()][cur.getY()] + 1;
            }
        }
    }

    private static class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int getX() {
            return x;
        }

        private int getY() {
            return y;
        }
    }
}
