package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7562 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] board;
    private static int[][] dist;
    private static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int size;
    private static Queue<Pair> queue = new LinkedList<>();
    private static int startX, startY;
    private static int goalX, goalY;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            size = Integer.parseInt(br.readLine());
            board = new int[size][size];
            dist = new int[size][size];

            initDist();

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            bfs();

            printResult();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initDist() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dist[i][j] = -1;
            }
        }
    }

    private static void bfs() {
        dist[startX][startY] = 0;
        queue.offer(new Pair(startX, startY));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= size || ny < 0 || ny >= size) {
                    continue;
                }

                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cur.getX()][cur.getY()] + 1;
                    queue.offer(new Pair(nx, ny));
                }
            }
        }
    }

    private static void printResult() throws IOException {
        bw.write(dist[goalX][goalY] + "\n");
    }

    private static class Pair {
        int x;
        int y;

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
