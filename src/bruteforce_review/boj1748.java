package bruteforce_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1748 {
    public static void main(String[] args) throws IOException {
        /*
        5 -> 12345 : 5
        15 -> 123456789101112131415 : 21

        1 ~ 9 : 9개
        10 ~ 99 : 90개
        100 ~ 999 : 900개
         */

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //수 입력
        int num = Integer.parseInt(bufferedReader.readLine());

        //자리수 계산
        int result = calculateTheNumberOfDigits(num);

        //자리수 출력
        System.out.println(result);
    }

    private static int calculateTheNumberOfDigits(int num) {
        String numToString = String.valueOf(num);
        int length = numToString.length();
        int cnt = 1;
        int result = 0;

        for (int i = 1; i < length; i++) {
            result += 9 * Math.pow(10, i - 1) * cnt;
            cnt++;
        }
        int value = (int) ((num - Math.pow(10, cnt - 1) + 1) * length);

        return result + value;
    }
}

/*
num = 120
9 + (2*90) + (120-100+1) * 3 = 9 + 180 + 63 = 252
 */