package backtracking;

import java.io.*;
import java.util.*;

public class Boj16987 {
    static int N;
    static Egg[] eggs;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(s, w);
        }

        func(0, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void func(int idx, int cnt) {
        if (idx == N) {
            answer = Math.max(answer, cnt);
            return;
        }

        Egg currentEgg = eggs[idx];

        if (currentEgg.S <= 0) {
            func(idx + 1, cnt);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (i == idx) {
                continue;
            }

            if (eggs[i].S <= 0) {
                continue;
            }

            eggs[i].S -= currentEgg.W;
            currentEgg.S -= eggs[i].W;

            hit = true;

            if (eggs[i].S <= 0) {
                cnt++;
            }
            if (currentEgg.S <= 0) {
                cnt++;
            }

            func(idx + 1, cnt);

            if (eggs[i].S <= 0) {
                cnt--;
            }
            if (currentEgg.S <= 0) {
                cnt--;
            }

            eggs[i].S += currentEgg.W;
            currentEgg.S += eggs[i].W;

        }

        if (!hit) {
            func(N, cnt);
        }
    }

    static class Egg {
        int S;
        int W;

        Egg(int s, int w) {
            this.S = s;
            this.W = w;
        }
    }
}
