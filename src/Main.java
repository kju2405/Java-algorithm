import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] board;
    static int[][][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        dist = new int[2][R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = bfs();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static int bfs() {
        queue = new LinkedList<>();
        dist[0][0][0] = 1;
        queue.offer(new Pair(0, 0, 0));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (cur.x == R - 1 && cur.y == C - 1) {
                return dist[cur.crashed][cur.x][cur.y];
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    if (dist[cur.crashed][nx][ny] != 0) {
                        continue;
                    }

                    queue.offer(new Pair(nx, ny, cur.crashed));
                    dist[cur.crashed][nx][ny] = dist[cur.crashed][cur.x][cur.y] + 1;
                } else {
                    if (cur.crashed == 1) {
                        continue;
                    }

                    if (dist[1][nx][ny] != 0) {
                        continue;
                    }

                    dist[1][nx][ny] = dist[0][cur.x][cur.y] + 1;
                    queue.offer(new Pair(nx, ny, 1));
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
    }
}