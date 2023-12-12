package math_review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class boj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


        //숫자 두개 입력
        String input = bufferedReader.readLine();
        String[] inputArray = input.split(" ");


        int minNum = Integer.parseInt(inputArray[0]);
        int maxNum = Integer.parseInt(inputArray[1]);

        //minNum, maxNum 사이의 소수 리스트 생성
        List<Integer> primeNumbers = getPrimeBetweenMinAndMax(minNum, maxNum);

        for (int i = 0; i < primeNumbers.size(); i++) {
            bufferedWriter.write(primeNumbers.get(i) + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static List<Integer> getPrimeBetweenMinAndMax(int minNum, int maxNum) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = minNum; i <= maxNum; i++) {
            if (i == 1) {
                continue;
            }

            boolean flag = isPrimeNumber(i);

            if (flag) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }

    private static boolean isPrimeNumber(int num) {
        int sqrtValue = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrtValue; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
