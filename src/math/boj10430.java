package math;

import java.io.*;
import java.util.StringTokenizer;

public class boj10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        bufferedWriter.write((A + B) % C + "\n");
        bufferedWriter.write((((A % C) + (B % C)) % C) + "\n");
        bufferedWriter.write((A * B) % C + "\n");
        bufferedWriter.write((((A % C) * (B % C)) % C) + "\n");

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
