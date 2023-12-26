package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj7576 {
    private static int[][] board;
    private static int[][] dist;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static Queue<Pair> queue = new LinkedList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        String inputMN = br.readLine();
        String[] mnArray = inputMN.split(" ");
        int M = Integer.parseInt(mnArray[0]);
        int N = Integer.parseInt(mnArray[1]);

        board = new int[N][M];
        dist = new int[N][M];

        fillBoard();

        calculateTomatoDay();

        int result = calculateResult();

        System.out.println(result);
    }

    private static void fillBoard() throws IOException{
        for (int i = 0; i < board.length; i++) {
            String[] lineArray = br.readLine().split(" ");
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(lineArray[j]);

                if (board[i][j] == 1) {
                    queue.offer(new Pair(i, j));
                }

                if (board[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }
    }

    private static void calculateTomatoDay() {
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                    continue;
                }

                if (board[nx][ny] == -1 || dist[nx][ny] >= 0) {
                    continue;
                }

                dist[nx][ny] = dist[cur.getX()][cur.getY()] + 1;
                queue.offer(new Pair(nx, ny));
            }
        }
    }

    private static int calculateResult() {
        int returnResult = 0;
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (dist[i][j] == -1) {
                    return -1;
                }
                returnResult = Math.max(returnResult, dist[i][j]);
            }
        }
        return returnResult;
    }
    
    private static class Pair{
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
