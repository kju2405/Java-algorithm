package math;

import java.io.*;

public class boj4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        while ((input = bufferedReader.readLine()) != null) {
            int n = Integer.parseInt(input);

            int baseNumber = 1;
            int cnt = 1;

            while (baseNumber % n != 0) {
                baseNumber = (baseNumber * 10 + 1) % n;
                cnt++;
            }

            bufferedWriter.write(cnt + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}