import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};
    private static String answer = "Hing";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        board = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

        bw.write(answer);

        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        int num = board[x][y];
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * num;
            int ny = y + dy[i] * num;

            if (nx >= board.length || ny >= board[0].length) {
                continue;
            }

            if (board[nx][ny] == -1) {
                answer = "HaruHaru";
                return;
            }

            if (!visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}