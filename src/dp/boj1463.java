package dp;

import java.io.*;

public class boj1463 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        arr = new int[num + 1];

        //초기값 설정
        arr[1] = 0;


        for (int i = 2; i < arr.length; i++) {
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MAX_VALUE;

            if (i % 3 == 0) {
                num1 = arr[i / 3] + 1;
            }

            if (i % 2 == 0) {
                num2 = arr[i / 2] + 1;
            }

            int num3 = arr[i - 1] + 1;

            int minNum = Math.min(num1, num2) < num3 ? Math.min(num1, num2) : num3;

            arr[i] = minNum;
        }

        bw.write(String.valueOf(arr[num]));

        br.close();
        bw.close();
    }
}
