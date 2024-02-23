package bfs;

import java.io.*;
import java.util.*;

public class Boj13549 {
    static int N, K;
    static int[] time;
    static Queue<Integer> queue;
    static int[] dx = {2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[100001];
        Arrays.fill(time, -1);

        time[N] = 0;

        queue = new LinkedList<>();
        queue.offer(N);

        bfs();

        bw.write(String.valueOf(time[K]));

        br.close();
        bw.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                if (i == 0) {
                    int nx = cur * dx[i];

                    if (nx < 0 || nx >= time.length) {
                        continue;
                    }

                    if (time[nx] == -1 || time[nx] > time[cur]) {
                        time[nx] = time[cur];
                        queue.offer(nx);
                    }
                } else {
                    int nx = cur + dx[i];

                    if (nx < 0 || nx >= time.length) {
                        continue;
                    }

                    if (time[nx] == -1 || time[nx] > (time[cur] + 1)) {
                        time[nx] = time[cur] + 1;
                        queue.offer(nx);
                    }
                }
            }
        }
    }
}