import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int N = 5;
    static int answer = 0;
    static int[] selected;
    static boolean[] visited;
    static Queue<Integer> queue;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new char[N][N];
        selected = new int[7];
        visited = new boolean[N * N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        func(0, 0, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void func(int idx, int cnt, int cntS) {
        if (cnt == 7) {
            if (cntS >= 4) {
                if (next()) {
                    answer++;
                }
            }
            return;
        }

        for (int i = idx; i < N * N; i++) {
            visited[i] = true;
            selected[cnt] = i;

            int row = i / N;
            int col = i % N;

            if (board[row][col] == 'S') {
                func(i + 1, cnt + 1, cntS + 1);
            } else {
                func(i + 1, cnt + 1, cntS);
            }
            visited[i] = false;
        }
    }

    private static boolean next() {
        queue = new LinkedList<>();
        boolean[] nextVisited = new boolean[N * N];
        int cnt = 1;
        queue.offer(selected[0]);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            nextVisited[cur] = true;

            for (int i = 0; i < dx.length; i++) {
                int nx = (cur / N) + dx[i];
                int ny = (cur % N) + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (!visited[nx * N + ny]) {
                    continue;
                }

                if (nextVisited[nx * N + ny]) {
                    continue;
                }

                queue.offer(nx * N + ny);
                nextVisited[nx * N + ny] = true;
                cnt++;
            }
        }

        if (cnt == 7) {
            return true;
        }
        return false;
    }
}