package math_review;

import java.io.*;

public class boj6588 {
    private static final int ARRAY_SIZE = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        //소수 여부를 저장한 배열 생성
        boolean[] primeNumberCheckArray = getPrimeNumberArray();

        //입력값이 0일때까지 반복문을 수행
        String inputNum;
        while (!(inputNum = bufferedReader.readLine()).equals("0")) {
            int num = Integer.parseInt(inputNum);

            //(반복문 내부) 제일 작은 수부터 인덱스와 (입력값-인덱스)의 값이 모두 소수일 경우 출력
            for (int i = 2; i < ARRAY_SIZE; i++) {
                if (primeNumberCheckArray[i] && primeNumberCheckArray[num - i]) {
                    bufferedWriter.write(num + " = " + i + " + " + (num - i)+"\n");
                    break;
                }
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static boolean[] getPrimeNumberArray() {
        boolean[] primeCheckArray = new boolean[ARRAY_SIZE];

        for (int i = 2; i < ARRAY_SIZE; i++) {

            boolean flag = isPrime(i);

            if (flag) {
                primeCheckArray[i] = true;
            }
        }

        return primeCheckArray;
    }

    private static boolean isPrime(int num) {
        int sqrtValue = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrtValue; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
