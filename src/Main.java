import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] board;
    private static int[] visited;
    private static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        board = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            board[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x].add(y);
            board[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(board[i], Collections.reverseOrder());
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(visited[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int idx) {
        visited[idx] = cnt++;

        for (int i = 0; i < board[idx].size(); i++) {
            int num = board[idx].get(i);
            if (visited[num] == 0) {
                dfs(num);
            }
        }
    }
}