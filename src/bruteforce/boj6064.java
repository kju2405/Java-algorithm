package bruteforce;

import java.io.*;

public class boj6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            String line = bufferedReader.readLine();
            int[] mnxy = stringToIntArray(line);

            int year = calculateYear(mnxy);

            bufferedWriter.write(year + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int calculateYear(int[] mnxy) {
        int m = mnxy[0];
        int n = mnxy[1];
        int x = mnxy[2];
        int y = mnxy[3];

        int limit = lcm(m, n); // 최소공배수를 최대 탐색 범위로 설정
        for (int year = x; year <= limit; year += m) {
            if ((year - y) % n == 0) {
                return year;
            }
        }
        return -1;
    }


//    private static int calculateYear(int[] mnxy) {
//        int m = mnxy[0];
//        int n = mnxy[1];
//        int x = mnxy[2] - 1;
//        int y = mnxy[3] - 1;
//
//        for (int k = 0; k < n; k++) {
//            int year = x + k * m;
//            if (year % n == y) {
//                return year + 1;
//            }
//        }
//
//        return -1;
//    }

    private static int[] stringToIntArray(String line) {
        String[] stringArray = line.split(" ");
        int[] result = new int[stringArray.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(stringArray[i]);
        }

        return result;
    }
}
