package math;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class boj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String numbers = bufferedReader.readLine();
        String[] numList = numbers.split(" ");

        int startNum = Integer.parseInt(numList[0]);
        int endNum = Integer.parseInt(numList[1]);

        List<Integer> primeNumbers = getPrimeNumber(startNum, endNum);

        for (int i = 0; i < primeNumbers.size(); i++) {
            bufferedWriter.write(primeNumbers.get(i) + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static List<Integer> getPrimeNumber(int startNum, int endNum) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = startNum; i <= endNum; i++) {
            if (i == 1) {
                continue;
            }

            boolean result = isPrimeNumber(i);
            if (result) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
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
