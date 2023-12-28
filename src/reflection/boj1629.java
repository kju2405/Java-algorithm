package reflection;

import java.io.*;
import java.util.StringTokenizer;

public class boj1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(POW(A, B, C));
    }

    private static long POW(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long val = POW(a, b / 2, c);
        val = val * val % c;
        if (b % 2 == 0) {
            return val;
        }
        return val * a % c;
    }
}
