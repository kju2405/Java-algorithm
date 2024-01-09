package bfs;

import java.io.*;
import java.util.*;

public class boj6593 {
    static char[][][] board;
    static int[][][] dist;

    static int L, R, C;
    static int Ez, Ex, Ey;

    static Queue<Pair> queue;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            board = new char[L][R][C];
            dist = new int[L][R][C];
            queue = new LinkedList<>();

            initBoard();

            bfs();

            if (dist[Ez][Ex][Ey] != -1) {
                bw.write("Escaped in " + dist[Ez][Ex][Ey] + " minute(s).\n");
            } else {
                bw.write("Trapped!\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < dz.length; i++) {
                int nz = cur.getZ() + dz[i];
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nz < 0 || nz >= L || nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (dist[nz][nx][ny] == -1 && board[nz][nx][ny] != '#') {
                    dist[nz][nx][ny] = dist[cur.getZ()][cur.getX()][cur.getY()] + 1;
                    queue.offer(new Pair(nz, nx, ny));
                }
            }
        }
    }

    private static void initBoard() throws IOException {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String line = br.readLine();
                for (int k = 0; k < C; k++) {
                    board[i][j][k] = line.charAt(k);
                    dist[i][j][k] = -1;
                    if (board[i][j][k] == 'S') {
                        queue.offer(new Pair(i, j, k));
                        dist[i][j][k] = 0;
                    }
                    if (board[i][j][k] == 'E') {
                        Ez = i;
                        Ex = j;
                        Ey = k;
                    }
                }
            }
            br.readLine();
        }
    }

    private static class Pair {
        int z, x, y;

        Pair(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }

        int getZ() {
            return z;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }
}
