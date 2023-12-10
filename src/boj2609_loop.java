import java.io.*;

public class boj2609_loop {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine();
        String[] numList = input.split(" ");

        int num1 = Integer.parseInt(numList[0]);
        int num2 = Integer.parseInt(numList[1]);


        int gcd = greatestCommonDivisor(num1, num2);
        int lcm = leastCommonMultiple(num1, num2, gcd);

        bufferedWriter.write(gcd + "\n");
        bufferedWriter.write(lcm + "\n");

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int leastCommonMultiple(int num1, int num2, int gcd) {
        return num1 * num2 / gcd;
    }

    private static int greatestCommonDivisor(int num1, int num2) {

        while (num2 != 0) {
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
        }

        return num1;
    }
}
