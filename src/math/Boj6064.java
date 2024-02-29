package math;

import java.io.*;
import java.util.*;

public class Boj6064 {
    static int T;
    static int M, N, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int answer = -1;
            int gcd = GCD(Math.max(M, N), Math.min(M, N));
            int lcm = M / gcd * N;

            if (N == y) {
                y = 0;
            }
            for (int year = x; year <= lcm; year += M) {
                if (year % N == y) {
                    answer = year;
                    break;
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }
        br.close();
        bw.close();
    }

    private static int GCD(int M, int N) {
        if (N == 0) {
            return M;
        }
        return GCD(N, M % N);
    }
}
