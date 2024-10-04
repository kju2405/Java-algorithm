import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[][] board;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        board = new int[rowSize][colSize];
        visited = new boolean[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < colSize; j++) {
                board[i][j] = arr[j] - '0';
            }
        }

        for (int i = 0; i < colSize; i++) {
            if (board[0][i] == 0 && !visited[0][i]) {
                dfs(0, i);
            }
        }

        String answer = "NO";
        for (int i = 0; i < colSize; i++) {
            if (visited[rowSize - 1][i]) {
                answer = "YES";
            }
        }

        bw.write(answer);
        bw.close();
        br.close();
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                continue;
            }

            if (board[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}