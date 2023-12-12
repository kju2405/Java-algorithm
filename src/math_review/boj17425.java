package math_review;

import java.io.*;
import java.util.Arrays;

public class boj17425 {
    private static final int ARRAY_SIZE = 1_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 최대값이 1,000,000이므로 인덱스가 1,000,000까지 존재하고 각 요소 까지의 합이 저장되어 있는 배열 생성
        long[] divisorSum = getDivisorSumArray();

        //데이터 갯수 입력
        int inputCnt = Integer.parseInt(bufferedReader.readLine());

        //각 데이터의 값을 입력받고 위에서 생성한 배열에서 입력받은 데이터의 인덱스 값 출력
        for (int i = 0; i < inputCnt; i++) {
            int index = Integer.parseInt(bufferedReader.readLine());
            bufferedWriter.write(divisorSum[index]+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static long[] getDivisorSumArray() {
        //배열 생성
        long[] divisorSum = new long[ARRAY_SIZE];

        //배열의 모든 인덱스에 1 저장
        Arrays.fill(divisorSum, 1);

        //인덱스 2부터 ARRAY_SIZE까지 반복문을 돌며 약수 더해주기
        for (int i = 2; i < ARRAY_SIZE; i++) {
            for (int j = 1; j * i < ARRAY_SIZE; j++) {
                divisorSum[i * j] += i;
            }
        }

        long[] divisorSumUnitlIndex = new long[ARRAY_SIZE];
        for (int i = 1; i < ARRAY_SIZE; i++) {
            divisorSumUnitlIndex[i] = divisorSumUnitlIndex[i - 1] + divisorSum[i];
        }
        //배열 리턴
        return divisorSumUnitlIndex;
    }
}
