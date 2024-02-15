import java.io.*;
import java.util.*;

public class review {
    static int N;
    static boolean[] isVisited1;
    static boolean[] isVisited2;
    static boolean[] isVisited3;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        isVisited1 = new boolean[N];
        isVisited2 = new boolean[2 * N - 1];
        isVisited3 = new boolean[2 * N - 1];

        func(0);

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }

    private static void func(int x) {
        if (x == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited1[i] && !isVisited2[x + i] && !isVisited3[x - i + N - 1]) {
                isVisited1[i] = true;
                isVisited2[x + i] = true;
                isVisited3[x - i + N - 1] = true;
                func(x + 1);
                isVisited1[i] = false;
                isVisited2[x + i] = false;
                isVisited3[x - i + N - 1] = false;
            }
        }
    }
}