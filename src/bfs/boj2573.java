package bfs;

import java.io.*;
import java.util.*;

public class boj2573 {
    static int R, C;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> queue;
    static int answer;
    static boolean isThereIce;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (true) {
            answer++;
            isThereIce = false;
            minusIceHeight();

            int cnt = calculateCnt();
            if (cnt >= 2) {
                break;
            }

            //다 녹으면 break;
            if (!isThereIce) {
                answer = 0;
                break;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int calculateCnt() {
        visited = new boolean[R][C];
        queue = new LinkedList<>();

        int cnt = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != 0 && !visited[i][j]) {
                    cnt++;
                    queue.offer(new Pair(i, j));
                    bfs();
                }
            }
        }

        return cnt;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (board[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Pair(nx, ny));
                }
            }
        }
    }

    private static void minusIceHeight() {
        int[][] subBoard = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 0) {
                    subBoard[i][j] = 0;
                    continue;
                }
                isThereIce = true;

                int cnt = 0;
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        continue;
                    }

                    if (board[nx][ny] == 0) {
                        cnt++;
                    }
                }

                subBoard[i][j] = board[i][j] - cnt;
                if (subBoard[i][j] < 0) {
                    subBoard[i][j] = 0;
                }
            }
        }
        board = subBoard;
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
