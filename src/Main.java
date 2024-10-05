import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static char[][] board;
    private static boolean[][] visited;
    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        board = new char[rowSize][colSize];
        visited = new boolean[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < colSize; j++) {
                board[i][j] = arr[j];
            }
        }

        int answer = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if (board[x][y] == '-') {
            int nx = x + dx[1];
            int ny = y + dy[1];

            if (nx >= board.length || ny >= board[0].length) {
                return;
            }

            if (board[nx][ny] == '-' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        } else {
            int nx = x + dx[0];
            int ny = y + dy[0];

            if (nx >= board.length || ny >= board[0].length) {
                return;
            }

            if (board[nx][ny] == '|' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}