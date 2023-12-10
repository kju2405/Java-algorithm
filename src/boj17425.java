import java.io.*;
import java.util.Arrays;

public class boj17425 {
    static final int MAX = 1_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] cSum = getDivisorSum();

        int caseCnt = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < caseCnt; i++) {
            int inputNum = Integer.parseInt(bufferedReader.readLine());
            long sum = cSum[inputNum];
            bufferedWriter.write(sum + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static long[] getDivisorSum() {
        long[] dp = new long[MAX];
        Arrays.fill(dp, 1);

        for (int i = 2; i < MAX; i++) {
            for (int j = 1; j * i < MAX; j++) {
                dp[i * j] += i;
            }
        }

        long[] cSum = new long[MAX];
        for (int i = 1; i < MAX; i++) {
            cSum[i] = cSum[i - 1] + dp[i];
        }
        return cSum;
    }
}
