package dfs_review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj11725 {
    static List<Integer>[] graph;
    static int[] parent;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        parent = new int[N + 1];

        int x, y;
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1, 1);

        for (int i = 2; i <= N; i++) {
            bw.write(String.valueOf(parent[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int idx,int pre) {
        parent[idx] = pre;

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);
            if (parent[next] == 0) {
                dfs(next, idx);
            }
        }
    }
}
