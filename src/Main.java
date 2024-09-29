import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    private static int[][] board;
    private static boolean[] visited;
    private static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x][y] = 1;
            board[y][x] = 1;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 1; i < board.length; i++) {
            if (board[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}