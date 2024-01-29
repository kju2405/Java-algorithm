package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj24479 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int N, M, R;
    static int order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //graph, visited 선언
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        //graph초기화
        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        //graph 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        //dfs
        dfs(R);

        //결과 출력
        for (int i = 1; i <= N; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.close();
        br.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        answer[idx] = ++order;

        for (int i = 0; i < graph[idx].size(); i++) {
            if (!visited[graph[idx].get(i)]) {
                dfs(graph[idx].get(i));
            }
        }
    }
}
