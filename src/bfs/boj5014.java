package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014 {
    private static int[] visit;
    private static int F, S, G, U, D;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visit = new int[F + 1];
        int[] dx = {U, -1*D};

        queue.offer(S);
        visit[S] = 1;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            if (cur == G) {
                bw.write(String.valueOf(visit[G] - 1));
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur + dx[i];
                if (nx < 1 || nx > F) {
                    continue;
                }

                if (visit[nx] == 0) {
                    queue.offer(nx);
                    visit[nx] = visit[cur] + 1;
                }
            }
        }

        if (visit[G] == 0) {
            bw.write("use the stairs");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
