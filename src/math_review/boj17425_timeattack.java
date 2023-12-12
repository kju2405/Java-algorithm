package math_review;

import java.io.*;

public class boj17425_timeattack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < num; i++) {
            int inputNum = Integer.parseInt(bufferedReader.readLine());
            long sum = getDivisorSum(inputNum);
            bufferedWriter.write(sum + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static long getDivisorSum(int inputNum) {
        long sum = 0;
        for (int i = 1; i <= inputNum; i++) {
            int cnt = inputNum / i;
            sum += cnt * i;
        }
        return sum;
    }
}
