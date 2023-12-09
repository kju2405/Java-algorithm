import java.io.*;

public class boj17427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long result = f(N);    //long 중요

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static long f(int number) {
        long result = 0;
        for (int i = 1; i <= number; i++) {
            result += i * (number / i);
        }
        return result;
    }
}
