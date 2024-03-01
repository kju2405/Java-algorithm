package bfs;

import java.io.*;
import java.util.*;

public class Boj13913 {
    static int N, K;
    static int[] dist;
    static int[] parent;
    static int[] dx = {2, -1, 1};
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        parent = new int[100001];

        Arrays.fill(dist, -1);

        int answer = bfs();

        List<Integer> trace = new ArrayList<>();
        for (int at = K; at != N; at = parent[at]) {
            trace.add(at);
        }
        trace.add(N);

        bw.write(String.valueOf(answer));
        bw.newLine();
        for (int i = trace.size() - 1; i >= 0; i--) {
            bw.write(trace.get(i) + " ");
        }

        br.close();
        bw.close();
    }

    private static int bfs() {
        queue = new LinkedList<>();
        dist[N] = 0;

        queue.offer(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                return dist[K];
            }

            for (int i = 0; i < dx.length; i++) {
                int nx;
                if (i == 0) {
                    nx = cur * dx[i];
                } else {
                    nx = cur + dx[i];
                }

                if (nx < 0 || nx > 100000) {
                    continue;
                }

                if (dist[nx] != -1) {
                    continue;
                }

                dist[nx] = dist[cur] + 1;
                parent[nx] = cur;
                queue.offer(nx);
            }
        }
        return -1;
    }
}
