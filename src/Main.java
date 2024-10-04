import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] board;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSizse = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            board = new boolean[rowSizse][colSize];
            visited = new boolean[rowSizse][colSize];

            while (cnt-- > 0) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());

                board[row][col] = true;
            }
            int answer = 0;
            for (int i = 0; i < rowSizse; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (board[i][j] && !visited[i][j]) {
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

    private static void bfs(int row, int col) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.addLast(new Pair(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                    continue;
                }

                if (board[nx][ny] && !visited[nx][ny]) {
                    queue.addLast(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static class Pair{
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}