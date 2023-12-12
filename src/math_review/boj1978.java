package math_review;

import java.io.*;

public class boj1978 {
    private static final int ARRAY_SIZE=1001;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        //사이즈가 1001이고 소수에는 true라고 표시되어있는 boolean 배열 생성
        boolean[] checkPrimeNumber = getPrimeNumberCheck();
        int primeNumberCnt = 0;

        int numCnt = Integer.parseInt(bufferedReader.readLine());

        //numCnt의 수만큼 숫자 입력받기
        String inputLine = bufferedReader.readLine();

        //문자열 split
        String[] inputStringNumbers = inputLine.split(" ");

        //각 String의 인덱스가 true인 개수 세기
        for (String element : inputStringNumbers) {
            int index = Integer.parseInt(element);
            if (checkPrimeNumber[index]) {
                primeNumberCnt++;
            }
        }

        //갯수 출력
        bufferedWriter.write(primeNumberCnt + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static boolean[] getPrimeNumberCheck() {
        boolean[] checkPrimeNumberArray = new boolean[ARRAY_SIZE];

        for (int i = 2; i < ARRAY_SIZE; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                checkPrimeNumberArray[i] = true;
            }
        }
        return checkPrimeNumberArray;
    }
}
