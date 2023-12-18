package bruteforce_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();
        String[] numbers = line.split(" ");

        //E,S,M 구하기
        int E = Integer.parseInt(numbers[0]);
        int S = Integer.parseInt(numbers[1]);
        int M = Integer.parseInt(numbers[2]);

        //연도 구하기
        int year = calculateYear(E, S, M);

        //출력
        System.out.println(year);
    }

    private static int calculateYear(int E, int S, int M) {
        int year = 1;
        while (true) {
            int e = year % 15 == 0 ? 15 : year % 15;
            int s = year % 28 == 0 ? 28 : year % 28;
            int m = year % 19 == 0 ? 19 : year % 19;

            if (e == E && s == S && m == M) {
                break;
            }

            year++;
        }

        return year;
    }
}
