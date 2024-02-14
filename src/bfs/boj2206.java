package bfs;

import java.io.*;
import java.util.*;

public class boj2206 {
    static int N, M;
    static int[][] board;
    static int[][][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<Pair> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dist = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        queue = new LinkedList<>();
        dist[0][0][0] = 1;
        queue.offer(new Pair(0, 0, 0));

        int answer = bfs();

        bw.write(String.valueOf(answer));

//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(dist[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        br.close();
        bw.close();
    }

    private static int bfs() {
        while (!queue.isEmpty()) {

            Pair cur = queue.poll();
//            System.out.println("cur.getCrashed() = " + cur.getCrashed());
//            System.out.println("cur.getX() = " + cur.getX());
//            System.out.println("cur.getY() = " + cur.getY());

            if (cur.getX() == N - 1 && cur.getY() == M - 1) {
                return dist[cur.getCrashed()][cur.getX()][cur.getY()];
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    if (dist[cur.getCrashed()][nx][ny] == 0) {
                        queue.offer(new Pair(nx, ny, cur.getCrashed()));
                        dist[cur.getCrashed()][nx][ny] = dist[cur.getCrashed()][cur.getX()][cur.getY()] + 1;
                    }
                } else {
                    if (cur.getCrashed() == 0) {
                        if (dist[1][nx][ny] == 0) {
                            queue.offer(new Pair(nx, ny, 1));
                            dist[1][nx][ny] = dist[cur.getCrashed()][cur.getX()][cur.getY()] + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Pair {
        int x;
        int y;
        int crashed;

        Pair(int x, int y, int crashed) {
            this.x = x;
            this.y = y;
            this.crashed = crashed;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        int getCrashed() {
            return crashed;
        }
    }
}
