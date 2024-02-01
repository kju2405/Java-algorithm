package dfs_review;

import java.io.*;
import java.util.StringTokenizer;

public class boj2644 {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int start, end;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        //graph, visited 선언
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        //graph초기화
        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        //dfs
        dfs(start, 0);

        //결과 출력
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void dfs(int idx, int cnt) {
        visited[idx] = true;

        if (idx == end) {
            answer = cnt;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (graph[idx][i] && !visited[i]) {
                dfs(i, cnt + 1);
            }
        }
    }
}
