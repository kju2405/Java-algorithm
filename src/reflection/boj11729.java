package reflection;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11729 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = (int) Math.pow(2, n) - 1;
        bw.write(cnt + "\n");

        hanoi(1, 3, n);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void hanoi(int a, int b, int n) throws IOException{
        if (n == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }
        hanoi(a, 6 - a - b, n - 1);
        bw.write(a + " " + b + "\n");
        hanoi(6 - a - b, b, n - 1);
    }
}
