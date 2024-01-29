package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11725 {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int x, y;
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.close();
        br.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);
            if (!visited[next]) {
                parent[next] = idx;
                dfs(next);
            }
        }
    }
}
