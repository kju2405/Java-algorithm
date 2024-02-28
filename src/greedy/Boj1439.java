package greedy;

import java.io.*;
import java.util.*;

public class Boj1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        int[] arr = new int[2];

        char pivot = S.charAt(0);

        arr[pivot - '0']++;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == pivot) {
                continue;
            }

            pivot = S.charAt(i);
            arr[pivot - '0']++;
        }

        int result = Math.min(arr[0], arr[1]);

        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }
}
