package dp;

import java.io.*;

public class boj12852 {
    static int[] arr;
    static String[] strArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        strArr = new String[N + 1];

        arr[1] = 0;
        strArr[1] = "1";

        for (int i = 2; i <= N; i++) {
            int[] num = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

            if (i % 3 == 0) {
                num[0] = arr[i / 3] + 1;
            }

            if (i % 2 == 0) {
                num[1] = arr[i / 2] + 1;
            }

            num[2] = arr[i - 1] + 1;

            int min = num[0];
            int minIdx = 0;
            for (int j = 0; j < num.length; j++) {
                if (min > num[j]) {
                    min = num[j];
                    minIdx = j;
                }
            }

            arr[i] = min;

            if (minIdx == 0) {
                minIdx = i / 3;
            } else if (minIdx == 1) {
                minIdx = i / 2;
            } else {
                minIdx = i - 1;
            }
            strArr[i] = i + " " + strArr[minIdx];
        }

        bw.write(String.valueOf(arr[N]));
        bw.newLine();
        bw.write(strArr[N]);
        br.close();
        bw.close();
    }
}
