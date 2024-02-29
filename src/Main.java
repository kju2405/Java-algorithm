import java.io.*;
import java.util.*;

public class Main {
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        arr = new boolean[to + 1];
        Arrays.fill(arr, true);

        arr[1] = false;

        for (int i = 2; i * i <= to; i++) {
            if (!arr[i]) {
                continue;
            }

            for (int j = 2 * i; j <= to; j += i) {
                arr[j] = false;
            }
        }

        for (int i = from; i <= to; i++) {
            if (arr[i]) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }


}