package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7569 {
    private static int M, N, H;
    private static int[][][] board;
    private static int[][][] dist;
    private static int[] dx = {1, 0, -1, 0, 0, 0};
    private static int[] dy = {0, 1, 0, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    private static Queue<Pair> queue = new LinkedList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[N][M][H];
        dist = new int[N][M][H];

        initBoard();
        initDist();

        bfs();

        int result = calculateResult();
        System.out.println(result);
    }

    private static void bfs() {
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j][k] == 1) {
                        queue.offer(new Pair(i, j, k));
                        dist[i][j][k] = 0;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int idx = 0; idx < 6; idx++) {
                int nx = cur.getX() + dx[idx];
                int ny = cur.getY() + dy[idx];
                int nz = cur.getZ() + dz[idx];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
                    continue;
                }

                if (board[nx][ny][nz] == 0 && dist[nx][ny][nz] == -1) {
                    queue.offer(new Pair(nx, ny, nz));
                    dist[nx][ny][nz] = dist[cur.getX()][cur.getY()][cur.getZ()] + 1;
                }
            }
        }
    }

    private static int calculateResult() {
        int result = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j][k] == 0 && dist[i][j][k] == -1) {
                        return -1;
                    }
                    result = Math.max(result, dist[i][j][k]);
                }
            }
        }
        return result;
    }

    private static void initBoard() throws IOException {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    board[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    private static void initDist() {
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    dist[i][j][k] = -1;
                }
            }
        }
    }

    private static class Pair {
        int x, y, z;

        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        private int getX() {
            return x;
        }

        private int getY() {
            return y;
        }

        private int getZ() {
            return z;
        }
    }
}
