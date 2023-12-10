import java.io.*;

public class boj2609_reflection {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine();

        String[] numList = input.split(" ");
        int num1 = Integer.parseInt(numList[0]);
        int num2 = Integer.parseInt(numList[1]);

        int gcd = greatestCommonDivisor(num1, num2);
        int lcm = leastCommonMultiply(num1, num2, gcd);

        bufferedWriter.write(gcd + "\n");
        bufferedWriter.write(lcm + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int greatestCommonDivisor(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return greatestCommonDivisor(num2, num1 % num2);
    }

    private static int leastCommonMultiply(int num1, int num2, int gcd) {
        return num1 * num2 / gcd;
    }
}
