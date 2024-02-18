package dp;

import java.io.*;
import java.util.*;

public class boj9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Long> arr = new ArrayList<>();

        arr.addAll(List.of(1L, 1L, 1L, 2L, 2L, 3L, 4L, 5L, 7L, 9L));

        for (int i = 10; i < 100; i++) {
            arr.add(arr.get(i - 2) + arr.get(i - 3));
        }

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int idx = Integer.parseInt(br.readLine());
            idx--;
            bw.write(String.valueOf(arr.get(idx)));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
