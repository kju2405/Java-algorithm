package bruteforce;

import java.io.*;

public class boj6064_sol2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        //testcase수 입력받기
        int testCaseNum = Integer.parseInt(bufferedReader.readLine());

        //for문 돌면서 mnxy입력받고 출력
        for (int i = 0; i < testCaseNum; i++) {
            String line = bufferedReader.readLine();
            String[] mnxyString = line.split(" ");

            int result = calculateYear(mnxyString);
            bufferedWriter.write(result + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int calculateYear(String[] mnxyString) {
        int m = Integer.parseInt(mnxyString[0]);
        int n = Integer.parseInt(mnxyString[1]);
        int x = Integer.parseInt(mnxyString[2]);
        int y = Integer.parseInt(mnxyString[3]);

        int result = -1;
        int index = 0;
        if (y == n) {
            y = 0;
        }

        //while문을 돌면서 year가 m*n이하일 경우에 한하여 조건 확인
        while (true) {
            int year = m * index + x;

            if (year > m * n) {
                break;
            }

            if (year % n == y) {
                result = year;
                break;
            }
            index++;
        }

        return result;
    }
}
