package math_review;

import java.io.*;

public class boj4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while ((input = bufferedReader.readLine()) != null) {
            int n = Integer.parseInt(input);
            int cnt = 1;
            int baseNum = 1;

            // 1로만 이루어진 숫자들을 %n연산을 통해 나누어 떨어지는 수 구하기
            // 매 연산마다 cnt증가
            while ((baseNum % n) != 0) {
                baseNum = (baseNum * 10 + 1) % n;
                cnt++;
            }
            //cnt출력
            bufferedWriter.write(cnt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
