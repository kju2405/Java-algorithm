package reflection;

import java.io.*;
import java.util.StringTokenizer;

public class boj1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = calcuateResult(n, r, c);
        System.out.println(result);
    }

    private static int calcuateResult(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        int half = (int) Math.pow(2, n) / 2;

        if (r < half && c < half) {
            return calcuateResult(n - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + calcuateResult(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + calcuateResult(n - 1, r - half, c);
        } else {
            return 3 * half * half + calcuateResult(n - 1, r - half, c - half);
        }
    }
}
