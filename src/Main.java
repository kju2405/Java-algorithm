import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static boolean[] visited;
    private static int answer;
    private static int comNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        comNum = Integer.parseInt(br.readLine());
        int pairNum = Integer.parseInt(br.readLine());

        board = new int[comNum + 1][comNum + 1];
        visited = new boolean[comNum + 1];

        while (pairNum-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            board[row][col] = 1;
            board[col][row] = 1;
        }

        dfs(1);

        for (int i = 1; i <= comNum; i++) {
            if (visited[i]) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer - 1));

        br.close();
        bw.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 1; i <= comNum; i++) {
            if (board[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}