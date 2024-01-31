package dp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class boj9095 {
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //초기값 설정
        list = new ArrayList<>();
        list.addAll(List.of(0, 1, 2, 4));

        int testNum = Integer.parseInt(br.readLine());
        int[] arr = new int[testNum];
        for (int i = 0; i < testNum; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxNum = -1;
        for (int i = 0; i < arr.length; i++) {
            if (maxNum < arr[i]) {
                maxNum = arr[i];
            }
        }

        fillList(maxNum);

        for (int i = 0; i < testNum; i++) {
            bw.write(String.valueOf(list.get(arr[i])));
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    private static void fillList(int maxNum) {
        for (int i = 4; i <= maxNum; i++) {
            list.add(list.get(i - 3) + list.get(i - 2) + list.get(i - 1));
        }
    }
}
