package dp;

import java.io.*;
import java.util.StringTokenizer;

public class boj1149 {
    static int[][] arr;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int houseNum = Integer.parseInt(br.readLine());

        arr = new int[houseNum][3];
        result = new int[houseNum][3];

        //arr 초기화
        for (int i = 0; i < houseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //초기화
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = arr[i][j];
            }
        }

        //DP
        for (int i = 1; i < houseNum; i++) {
            result[i][0] = Math.min(result[i - 1][1], result[i - 1][2]) + arr[i][0];
            result[i][1] = Math.min(result[i - 1][0], result[i - 1][2]) + arr[i][1];
            result[i][2] = Math.min(result[i - 1][0], result[i - 1][1]) + arr[i][2];
        }

        int answer = Math.min(Math.min(result[houseNum - 1][0], result[houseNum - 1][1]), result[houseNum - 1][2]);


        //결과 출력
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
