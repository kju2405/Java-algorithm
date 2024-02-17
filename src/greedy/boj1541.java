package greedy;

import java.io.*;
import java.util.*;

public class boj1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String expression = br.readLine();

        StringTokenizer st = new StringTokenizer(expression, "-");
        int[] nums = new int[st.countTokens()];

        int idx = 0;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            String[] arr = token.split("\\+");
            int value = 0;
            for (int i = 0; i < arr.length; i++) {
                value += Integer.parseInt(arr[i]);
            }
            nums[idx++] = value;
        }

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result -= nums[i];
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }
}
