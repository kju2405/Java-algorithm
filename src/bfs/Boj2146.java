package bfs;

import java.io.*;
import java.util.*;

public class Boj2146 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N입력
        N = Integer.parseInt(br.readLine());

        //배열 선언
        board = new int[N][N];

        //배열 초기화
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬별로 숫자 변경
        visited = new boolean[N][N];
        int islandNum = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    board[i][j] = islandNum;
                    reWriteIslandNum(i, j, islandNum++);
                }
            }
        }

        //bfs
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > 1) {
                    int value = bfs(i, j, board[i][j]);
                    if (value == -1) {
                        continue;
                    }
                    answer = Math.min(value, answer);
                }
            }
        }

        bw.write(String.valueOf(answer - 1));
        br.close();
        bw.close();
    }

    private static void reWriteIslandNum(int x, int y, int num) {
        queue = new LinkedList<>();

        queue.offer(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (board[nx][ny] == 1 && !visited[nx][ny]) {
                    board[nx][ny] = num;
                    visited[nx][ny] = true;
                    queue.offer(new Pair(nx, ny));
                }
            }
        }
    }

    private static int bfs(int x, int y, int boardNum) {
        queue = new LinkedList<>();
        dist = new int[N][N];
        queue.offer(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (board[cur.x][cur.y] != boardNum && board[cur.x][cur.y] != 0) {
                return dist[cur.x][cur.y];
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (dist[nx][ny] != 0 || board[nx][ny] == boardNum) {
                    continue;
                }

                queue.offer(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }

        return -1;
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
