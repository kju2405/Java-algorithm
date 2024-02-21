import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] inputNums;
    static int[] resultArr;
    static Set<String> result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputNums = new int[N];
        resultArr = new int[M];
        result = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputNums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputNums);

        func(0, 0);

        for (String val : result) {
            bw.write(val);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void func(int idx, int start) {
        if (idx == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(resultArr[i] + " ");
            }
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < N; i++) {
            resultArr[idx] = inputNums[i];
            func(idx + 1, i);
        }
    }
}