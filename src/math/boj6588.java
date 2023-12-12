package math;

import java.io.*;

public class boj6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            boolean flag = false;
            int inputNum = Integer.parseInt(bufferedReader.readLine());
            if (inputNum == 0) {
                break;
            }
            for (int i = inputNum - 2; i > 2; i--) {
                boolean result = isPrimeNumber(i);
                if (result) {
                    int oppositeNum = inputNum - i;
                    boolean primeNumber = isPrimeNumber(oppositeNum);
                    if (primeNumber) {
                        bufferedWriter.write(String.format("%d = %d + %d\n", inputNum, oppositeNum, i));
                        flag = true;
                        break;
                    }
                }
            }

            if (!flag) {
                bufferedWriter.write("Goldhach's conjecture is wrong.\n");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static boolean isPrimeNumber(int number) {
        int sqrtValue = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrtValue; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
