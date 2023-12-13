package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        String[] inputArray = input.split(" ");

        int year = 1;

        int E = Integer.parseInt(inputArray[0]);
        int S = Integer.parseInt(inputArray[1]);
        int M = Integer.parseInt(inputArray[2]);

        while (true) {
            int yearE = year % 15 == 0 ? 15 : year % 15;
            int yearS = year % 28 == 0 ? 28 : year % 28;
            int yearM = year % 19 == 0 ? 19 : year % 19;
            if (yearE == E && yearS == S && yearM == M) {
                break;
            }
            year++;
        }

        System.out.println(year);
    }
}
