package backtracking;

import java.io.*;
import java.util.*;

public class Boj1759 {
    static int L, C;
    static char[] arr;
    static char[] result;
    static boolean[] isUsed;
    static char[] aeiou = {'a', 'e', 'i', 'o', 'u'};

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        result = new char[L];
        isUsed = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        func(0, 0);

        br.close();
        bw.close();
    }

    private static void func(int idx, int start) throws IOException{
        if (idx == L) {
            int cnt = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < aeiou.length; j++) {
                    if (result[i] == aeiou[j]) {
                        cnt++;
                    }
                }
            }

            if (cnt < 1 || 2 > L - cnt) {
                return;
            }
            String tmp = new String(result);
            bw.write(tmp);
            bw.newLine();
            return;
        }

        for (int i = start; i < C; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                result[idx] = arr[i];
                func(idx + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
}