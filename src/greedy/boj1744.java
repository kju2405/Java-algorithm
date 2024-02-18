package greedy;

import java.io.*;
import java.util.*;

public class boj1744 {
    static int[] inputNums;
    static int size;
    static boolean isThereZero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(br.readLine());

        inputNums = new int[size];

        for (int i = 0; i < size; i++) {
            inputNums[i] = Integer.parseInt(br.readLine());
            if (inputNums[i] == 0) {
                isThereZero = true;
            }
        }

        Arrays.sort(inputNums);

        int answer = 0;
        for (int i = size - 1; i > 0; i -= 2) {
            if (inputNums[i] > 1 && inputNums[i - 1] > 1) {
                answer += (inputNums[i] * inputNums[i - 1]);
                inputNums[i] = 0;
                inputNums[i - 1] = 0;
            }
        }

        for (int i = 0; i < size - 1; i += 2) {
            if (inputNums[i] < 0 && inputNums[i + 1] < 0) {
                answer += (inputNums[i] * inputNums[i + 1]);
                inputNums[i] = 0;
                inputNums[i + 1] = 0;
            }
        }

        for (int i = 0; i < size; i++) {
            if (inputNums[i] < 0 && isThereZero) {
                inputNums[i] = 0;
                isThereZero = false;
            }
            answer += inputNums[i];
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
