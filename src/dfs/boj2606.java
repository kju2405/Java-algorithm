package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class boj2606 {

    private static boolean[][] graph;
    private static boolean[] visit;
    private static int N, M;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];

        int x, y;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = true;
        }

        dfs(1);

        bw.write(String.valueOf(answer - 1));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int idx) {
        visit[idx] = true;
        answer++;

        for (int i = 1; i <= N; i++) {
            if (!visit[i] && graph[idx][i]) {
                dfs(i);
            }
        }
    }
}
