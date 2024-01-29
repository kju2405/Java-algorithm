package dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2644 {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, GX, GY, M;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        GX = Integer.parseInt(st.nextToken());
        GY = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        //graph, visited 선언
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = -1;

        //graph 채우기
        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        //bfs
        dfs(GX, 0);

        //결과 출력
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static void dfs(int cur, int dist) {
        visited[cur] = true;

        if (cur == GY) {
            answer = dist;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (graph[cur][i] && !visited[i]) {
                dfs(i, dist + 1);
            }
        }
    }
}
