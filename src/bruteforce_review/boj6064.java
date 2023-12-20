package bruteforce_review;

import java.io.*;

public class boj6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseNum = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCaseNum; i++) {
            String inputLine = bufferedReader.readLine();
            String[] mnxy = inputLine.split(" ");
            int M = Integer.parseInt(mnxy[0]);
            int N = Integer.parseInt(mnxy[1]);
            int x = Integer.parseInt(mnxy[2]);
            int y = Integer.parseInt(mnxy[3]);

            int year = calculateYear(M, N, x, y);
            bufferedWriter.write(year + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int calculateYear(int m, int n, int x, int y) {
        //최대 공배수 구하기(범위 설정)
        int lcm = getLcm(m, n);

        //최소 공배수까지 수를 증가시키며 연도 확인
        for (int i = 0; i * m <= lcm; i++) {
            int year = i * m + x;
            /*
            if(year % n == y)를 처음에 생각했다.
            이 경우 year가 66이고 m,n,x,y가 각각 13,11,1,11인 경우에는 year%n의 결과가0이지만 실제로는 11이 되어야한다.
            따라서 아래처럼 조건을 주어야한다.
             */
            if ((year - y) % n == 0) {
                return year;
            }
        }

        return -1;
    }

    private static int getLcm(int m, int n) {
        int gcd = getGcd(m, n);
        return m * n / gcd;
    }

    private static int getGcd(int m, int n) {
        /*
        18와 4의 최대 공약수 구하기
        1. 4, 2
        2. 2, 0
         */
        if (n == 0) {
            return m;
        }
        return getGcd(n, m % n);
    }
}


/*
반례
1
13 11 1 11
 */