package dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1260 {
    static int N, M, R;
    static boolean[][] graph;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static int order;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //graph, visited, answer 선언
        graph = new boolean[N + 1][N + 1];
        dfsVisited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];

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
        dfs(R);
        System.out.println();

        //order 초기화
        order = 0;

        //bfs
        bfs();

        br.close();
    }

    private static void dfs(int idx) {
        dfsVisited[idx] = true;
        System.out.print(idx + " ");

        for (int i = 1; i <= N; i++) {
            if (graph[idx][i] && !dfsVisited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs() {
        queue = new LinkedList<>();

        queue.offer(R);
        bfsVisited[R] = true;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            System.out.print(idx + " ");

            for (int i = 1; i <= N; i++) {
                if (graph[idx][i] && !bfsVisited[i]) {
                    queue.offer(i);
                    bfsVisited[i] = true;
                }
            }
        }
    }
}
