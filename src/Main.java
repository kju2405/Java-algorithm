import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> queue;
    static int[] dist;
    static int N, K;
    static int[] dx = {2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        Arrays.fill(dist, -1);

        dist[N] = 0;

        bfs();

        bw.write(String.valueOf(dist[K]));

        br.close();
        bw.close();
    }

    private static void bfs() {
        queue = new LinkedList<>();

        queue.offer(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx;
                if (i == 0) {
                    nx = cur * dx[i];

                    if (nx < 0 || nx >= dist.length) {
                        continue;
                    }

                    if (dist[nx] > dist[cur] || dist[nx] == -1) {
                        dist[nx] = dist[cur];
                        queue.offer(nx);
                    }
                } else {
                    nx = cur + dx[i];

                    if (nx < 0 || nx >= dist.length) {
                        continue;
                    }

                    if (dist[nx] > dist[cur] + 1 || dist[nx] == -1) {
                        dist[nx] = dist[cur] + 1;
                        queue.offer(nx);
                    }
                }
            }
        }
    }
}