package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2468 {
    private static int N;
    private static int[][] board;
    private static boolean[][] visit;
    private static Queue<Pair> queue;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i <= 100; i++) {
            queue = new LinkedList<>();
            initVisit();
            int bfsResult = bfs(i);
            result = Math.max(result, bfsResult);
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initVisit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = false;
            }
        }
    }

    private static int bfs(int rain) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && board[i][j] > rain) {
                    queue.offer(new Pair(i, j));
                    visit[i][j] = true;
                    result++;

                    while (!queue.isEmpty()) {
                        Pair cur = queue.poll();

                        for (int k = 0; k < dx.length; k++) {
                            int nx = cur.getX() + dx[k];
                            int ny = cur.getY() + dy[k];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                                continue;
                            }

                            if (board[nx][ny] > rain && !visit[nx][ny]) {
                                queue.offer(new Pair(nx, ny));
                                visit[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    private static class Pair {
        int x, y;

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