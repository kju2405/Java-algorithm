import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(bufferedReader.readLine());
        st = new StringTokenizer(bufferedReader.readLine(), " ");

        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = arr[0] * arr[count - 1];

        bufferedWriter.write(answer + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
