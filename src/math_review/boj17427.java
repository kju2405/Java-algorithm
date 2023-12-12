package math_review;

import java.io.*;

public class boj17427 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        long sum = getDivisorSum(n);

        bufferedWriter.write(sum + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static long getDivisorSum(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = n / i;
            sum += i * cnt;
        }
        return sum;
    }
}
