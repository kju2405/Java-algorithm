package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int goal = Integer.parseInt(bufferedReader.readLine());
        boolean[] isBroken = new boolean[10];


        int wrongButtonCnt = Integer.parseInt(bufferedReader.readLine());
        if (wrongButtonCnt != 0) {
            String wrongButtonLine = bufferedReader.readLine();
            String[] wrongNumbers = wrongButtonLine.split(" ");


            for (int i = 0; i < wrongButtonCnt; i++) {
                isBroken[Integer.parseInt(wrongNumbers[i])] = true;
            }
        }

        int min = Math.abs(goal - 100);

        for (int i = 0; i <= 999999; i++) {
            String channelNum = String.valueOf(i);
            int cnt = 0;
            boolean flag = false;
            for (int j = 0; j < channelNum.length(); j++) {
                int idx = channelNum.charAt(j) - '0';
                if (isBroken[idx]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            cnt += (channelNum.length() + Math.abs(goal - i));
            min = Math.min(min, cnt);
        }

        System.out.println(min);
    }
}
