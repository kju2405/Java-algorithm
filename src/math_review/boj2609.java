package math_review;

import java.io.*;

public class boj2609 {
    public static void main(String[] args) throws IOException {
        // 32 6
        // 6, 2
        // 2, 0  => 32와 6의 최대공약수는 2, 최소 공배수는 32*6/2

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputStringNumbers = bufferedReader.readLine();

        String[] inputStringNumbersArray = inputStringNumbers.split(" ");
        int[] inputIntNumbersArray = new int[inputStringNumbersArray.length];

        for (int i = 0; i < inputStringNumbersArray.length; i++) {
            inputIntNumbersArray[i] = Integer.parseInt(inputStringNumbersArray[i]);
        }

        int maxNum, minNum;

        if (inputIntNumbersArray[0] < inputIntNumbersArray[1]) {
            minNum = inputIntNumbersArray[0];
            maxNum = inputIntNumbersArray[1];
        } else {
            minNum = inputIntNumbersArray[1];
            maxNum = inputIntNumbersArray[0];
        }

        int gcd = getGCD(maxNum, minNum);
        int lcm = getLCM(maxNum, minNum, gcd);

        bufferedWriter.write(gcd + "\n");
        bufferedWriter.write(lcm + "\n");

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int getLCM(int maxNum, int minNum, int gcd) {
        return maxNum * minNum / gcd;
    }

    private static int getGCD(int maxNum, int minNum) {
        if (minNum == 0) {
            return maxNum;
        }

        return getGCD(minNum, maxNum % minNum);
    }
}
