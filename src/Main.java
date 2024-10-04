import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int colSize = Integer.parseInt(st.nextToken());
            int rowSize = Integer.parseInt(st.nextToken());

            if (rowSize == 0 && colSize == 0) {
                break;
            }

            board = new int[rowSize][colSize];
            visited = new boolean[rowSize][colSize];

            for (int i = 0; i < rowSize; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < colSize; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void bfs(int x, int y) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.addLast(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.pollFirst();
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                    continue;
                }

                if (board[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.addLast(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}