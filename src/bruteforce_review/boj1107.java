package bruteforce_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isBroken = new boolean[10];

        //이동채널 N 입력
        int N = Integer.parseInt(bufferedReader.readLine());

        //고장난 버튼 갯수 입력
        int M = Integer.parseInt(bufferedReader.readLine());

        //고장난 버튼 입력
        if (M != 0) {
            String line = bufferedReader.readLine();
            storeIsBroken(line, isBroken);
        }

        //0부터 999999까지 돌면서 min을 구한다.
        int min = CalculateMin(N, isBroken);

        //min출력
        System.out.println(min);

    }

    private static void storeIsBroken(String line, boolean[] isBroken) {
        String[] s = line.split(" ");
        for (int i = 0; i < s.length; i++) {
            int brokenNum = Integer.parseInt(s[i]);
            isBroken[brokenNum] = true;
        }
    }

    private static int CalculateMin(int n, boolean[] isBroken) {
        //현재 채널이 100이므로 100에서 목표 채널까지 이동할 수 있는 최소 횟수
        int min = Math.abs(n - 100);

        //0부터 번호로 누르고 화살표로 이동 횟수. 숫자에 부서진 숫자가 포함되면 break;
        for (int i = 0; i <= 999999; i++) {
            String from = String.valueOf(i);
            boolean flag = false;
            for (int j = 0; j < from.length(); j++) {
                int num = from.charAt(j) - '0';
                if (isBroken[num]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            int minNumUsingArrow = Math.abs(n - i) + from.length();
            min = Math.min(min, minNumUsingArrow);
        }

        return min;
    }
}
