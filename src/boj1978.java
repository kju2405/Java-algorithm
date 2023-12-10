import java.io.*;

public class boj1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(bufferedReader.readLine());
        int cnt = 0;

        String input = bufferedReader.readLine();
        String[] numList = input.split(" ");

        for (int i = 0; i < numCnt; i++) {
            int num = Integer.parseInt(numList[i]);
            if (num == 1) {
                continue;
            }

            int divisorCnt = countDivisor(num);
            if (divisorCnt == 0) {
                cnt++;
            }
        }

        bufferedWriter.write(cnt + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int countDivisor(int num) {
        int sqrtValue = (int) Math.sqrt(num);
        int cnt = 0;

        for (int i = 2; i <= sqrtValue; i++) {
            if (num % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
