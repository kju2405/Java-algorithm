import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[][] board;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int comNum = Integer.parseInt(br.readLine());
        int pairNum = Integer.parseInt(br.readLine());

        board = new int[comNum + 1][comNum + 1];
        visited = new boolean[comNum + 1];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        visited[1] = true;

        while (pairNum-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            board[row][col] = 1;
            board[col][row] = 1;
        }

        int ans = 0;

        while (!queue.isEmpty()) {
            int com = queue.pollFirst();
            for (int i = 1; i <= comNum; i++) {
                if (board[com][i] == 1 && !visited[i]) {
                    queue.addLast(i);
                    visited[i] = true;
                    ans++;
                }
            }
        }

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}