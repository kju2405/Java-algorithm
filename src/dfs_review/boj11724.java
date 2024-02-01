package dfs_review;

import java.io.*;
import java.util.StringTokenizer;

public class boj11724 {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N,M입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //graph, visited 선언
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        //graph채우기
        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        //dfs
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        //값 출력
        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[idx][i] && !visited[i]) {
                dfs(i);
            }
        }
        }
}
