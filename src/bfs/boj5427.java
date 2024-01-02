package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5427 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static char[][] board;
    private static int[][] fireDist, sangeunDist;
    private static int w, h;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static Queue<Pair> fireQueue;
    private static Queue<Pair> sangeunQueue;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new char[h][w];
            fireDist = new int[h][w];
            sangeunDist = new int[h][w];

            fireQueue = new LinkedList<>();
            sangeunQueue = new LinkedList<>();

            initDist();
            initBoard();

            fireBfs();
            sangeunBfs();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initDist() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                fireDist[i][j] = -1;
                sangeunDist[i][j] = -1;
            }
        }
    }

    private static void initBoard() throws IOException {
        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == '@') {
                    sangeunDist[i][j] = 0;
                    sangeunQueue.offer(new Pair(i, j));
                }

                if (board[i][j] == '*') {
                    fireDist[i][j] = 0;
                    fireQueue.offer(new Pair(i, j));
                }
            }
        }
    }

    private static void fireBfs() {
        while (!fireQueue.isEmpty()) {
            Pair cur = fireQueue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if (board[nx][ny] != '#' && fireDist[nx][ny] == -1) {
                    fireDist[nx][ny] = fireDist[cur.getX()][cur.getY()] + 1;
                    fireQueue.offer(new Pair(nx, ny));
                }
            }
        }
    }

    private static void sangeunBfs() throws IOException {
        while (!sangeunQueue.isEmpty()) {
            Pair cur = sangeunQueue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    bw.write(sangeunDist[cur.getX()][cur.getY()] + 1 + "\n");
                    return;
                }

                if (board[nx][ny] == '#' || sangeunDist[nx][ny] != -1) {
                    continue;
                }
                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= sangeunDist[cur.getX()][cur.getY()] + 1) {
                    continue;
                }
                sangeunDist[nx][ny] = sangeunDist[cur.getX()][cur.getY()] + 1;
                sangeunQueue.offer(new Pair(nx, ny));
            }
        }
        bw.write("IMPOSSIBLE\n");
    }

    private static class Pair {
        int x, y;

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
