package dfs_review;

import java.io.*;
import java.util.*;

public class boj1260 {
    static boolean[][] graph;
    static boolean[] visited;
    static Queue<Integer> queue;
    static int N, M, V;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

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
        dfs(V);
        bw.newLine();

        //bfs
        visited = new boolean[N + 1];
        queue = new LinkedList<>();
        bfs();


        //출력
        br.close();
        bw.close();
    }

    private static void dfs(int idx) throws IOException{
        visited[idx] = true;
        bw.write(idx + " ");

        for (int i = 1; i <= N; i++) {
            if (graph[idx][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs() throws IOException{
        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            bw.write(cur+" ");

            for (int i = 1; i <= N; i++) {
                if (graph[cur][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
