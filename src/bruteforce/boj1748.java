package bruteforce;

import java.io.*;

public class boj1748 {
    public static void main(String[] args) throws IOException {
        //1의 자리 1~9 9개
        //2의 자리 10~99 90개
        //3의 자리 100~999 900개
        //...
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        int inputLen = input.length();

        int resultLength = 0;

        //입력값의 자리수보다 한자리 작은 수까지의 길이 합
        for (int i = 1; i < inputLen; i++) {
            resultLength += (int) (i * 9 * Math.pow(10, (i - 1)));
        }

        //입력값의 자리수 * (입력값 - Math.pow(10,입력값길이-1)+1)
        resultLength += (int) ((Integer.parseInt(input) - Math.pow(10, (inputLen - 1)) + 1) * inputLen);

        //결과값 출력
        System.out.println(resultLength);
    }
}
