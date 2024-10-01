import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer>[] board;
    private static int[] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        board = new ArrayList[n + 1];
        visited = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            board[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x].add(y);
            board[y].add(x);
        }

        dfs(1, 1);

        for (int i = 2; i <= n; i++) {
            bw.write(String.valueOf(visited[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int idx, int parent) {
        if (visited[idx] != 0) {
            return;
        }
        visited[idx] = parent;

        for (int i = 0; i < board[idx].size(); i++) {
            int num = board[idx].get(i);
            dfs(num, idx);
        }
    }
}