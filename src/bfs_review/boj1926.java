package bfs_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1926 {
    private static int[][] board;
    private static boolean[][] visit;
    private static int picNum = 0;
    private static int picMaxSize = 0;
    private static Queue<Pair> queue = new LinkedList<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        String[] rowColArray = line.split(" ");

        int row = Integer.parseInt(rowColArray[0]);
        int col = Integer.parseInt(rowColArray[1]);

        board = new int[row][col];
        visit = new boolean[row][col];

        fillBoard();

        calculateResult();

        System.out.println(picNum);
        System.out.println(picMaxSize);
    }

    private static void calculateResult() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                picNum++;
                queue.offer(new Pair(i, j));
                visit[i][j] = true;

                int picSize = 0;

                while (!queue.isEmpty()) {
                    Pair cur = queue.poll();
                    picSize++;
                    for (int idx = 0; idx < 4; idx++) {
                        int nx = cur.x + dx[idx];
                        int ny = cur.y + dy[idx];

                        if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[i].length) {
                            continue;
                        }
                        if (board[nx][ny] == 0 || visit[nx][ny]) {
                            continue;
                        }
                        queue.offer(new Pair(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
                picMaxSize = Math.max(picSize, picMaxSize);
            }
        }
    }

    private static void fillBoard() throws IOException{
        for (int i = 0; i < board.length; i++) {
            String line = br.readLine();
            String[] rowArray = line.split(" ");
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(rowArray[j]);
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
