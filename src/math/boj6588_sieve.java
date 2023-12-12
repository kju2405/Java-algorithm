package math;

import java.io.*;

public class boj6588_sieve {
    private static final int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] numberList = new boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++) {
            numberList[i] = true;
        }

        numberList = primeNumberSeive(numberList);

        while (true) {
            int inputNum = Integer.parseInt(bufferedReader.readLine());
            if (inputNum == 0) {
                break;
            }

            String sumExpression = findSumNum(numberList, inputNum);
            bufferedWriter.write(sumExpression + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static String findSumNum(boolean[] numberList, int inputNum) {
        for (int i = 2; i <= inputNum / 2; i++) {
            if (numberList[i] && numberList[inputNum - i]) {
                return inputNum + " = " + i + " + " + (inputNum - i);
            }
        }

        return "Goldhach's conjecture is wrong.";
    }

    private static boolean[] primeNumberSeive(boolean[] numberList) {
        for (int i = 2; i <= (int) Math.sqrt(MAX); i++) {
            for (int j = i * i; j <= MAX; j += i) {
                if (numberList[j]) {
                    numberList[j] = false;
                }
            }
        }
        return numberList;
    }
}
