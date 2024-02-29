package math;

import java.io.*;
import java.util.*;

public class Boj11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                bw.write(String.valueOf(i));
                bw.newLine();
                num /= i;
            }
        }

        if (num != 1) {
            bw.write(String.valueOf(num));
        }

        br.close();
        bw.close();
    }
}
