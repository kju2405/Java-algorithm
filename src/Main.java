import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int W, H;
    static int[][] board;
    static int[][] dist;
    static Queue<Pair> queue;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] horseDx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] horseDy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        dist = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < H; i++) {
            Arrays.fill(dist[i], -1);
        }

        dist[0][0] = 0;

        bfs();

        bw.write(String.valueOf(dist[H - 1][W - 1]));

        br.close();
        bw.close();
    }

    private static void bfs() {
        queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 0));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                    continue;
                }

                if (board[nx][ny] == 1) {
                    continue;
                }

                if (dist[nx][ny] == -1 || dist[nx][ny] > dist[cur.x][cur.y] + 1) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    queue.offer(new Pair(nx, ny, cur.horse));
                }
            }

            if (cur.horse >= K) {
                continue;
            }

            for (int i = 0; i < horseDx.length; i++) {
                int nx = cur.x + horseDx[i];
                int ny = cur.y + horseDy[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                    continue;
                }

                if (board[nx][ny] == 1) {
                    continue;
                }

                if (dist[nx][ny] == -1 || dist[nx][ny] > dist[cur.x][cur.y] + 1) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    queue.offer(new Pair(nx, ny, cur.horse + 1));
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;
        int horse;

        Pair(int x, int y, int horse) {
            this.x = x;
            this.y = y;
            this.horse = horse;
        }
    }
}