package math_review;

import java.io.*;
import java.util.Arrays;

public class boj1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(bufferedReader.readLine());

        String divisor = bufferedReader.readLine();
        String[] divisorArray = divisor.split(" ");
        int[] divisorIntArray = new int[num];

        for (int i = 0; i < divisorArray.length; i++) {
            divisorIntArray[i] = Integer.parseInt(divisorArray[i]);
        }

        Arrays.sort(divisorIntArray);

        int result = divisorIntArray[0] * divisorIntArray[num - 1];

        bufferedWriter.write(result + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
