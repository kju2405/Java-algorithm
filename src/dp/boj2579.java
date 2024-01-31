package dp;

import java.io.*;

public class boj2579 {
    static int[][] arr;
    static int[] floor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        arr = new int[num][3];
        floor = new int[num];

        //floor 초기화
        for (int i = 0; i < num; i++) {
            floor[i] = Integer.parseInt(br.readLine());
        }

        //num이 1일경우
        if (num == 1) {
            bw.write(String.valueOf(floor[0]));
            br.close();
            bw.close();
            System.exit(0);
        }

        //arr 초기화
        arr[0][1] = floor[0];
        arr[0][2] = 0;
        arr[1][1] = floor[1];
        arr[1][2] = floor[0] + floor[1];

        //arr 채우기
        for (int i = 2; i < num; i++) {
            arr[i][1] = Math.max(arr[i - 2][1], arr[i - 2][2]) + floor[i];
            arr[i][2] = arr[i - 1][1] + floor[i];
        }

        int result = Math.max(arr[num-1][1], arr[num-1][2]);
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
