package dfs_review;

import java.io.*;
import java.util.*;

public class boj24479 {
    static List<Integer>[] graph;
    static int[] visited;
    static int N, M, R;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N,M,R 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //graph, visited 선언
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new int[N + 1];

        //graph초기화
        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        //오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        //dfs
        dfs(R);

        //결과 출력
        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(visited[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int idx) {
        visited[idx] = ++cnt;

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }
}
