package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj24480 {
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

        //graph, visited, answer 선언
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        //graph 초기화
        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        //graph 내림차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Comparator.reverseOrder());
        }

        //dfs
        dfs(R);

        //정답 출력
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
            int next = graph[idx].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
