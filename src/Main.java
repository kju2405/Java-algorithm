import java.io.*;

public class Main {
    private static int N;
    private static boolean[] rightTop, rightBottom, right, down;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        rightTop = new boolean[2 * N - 1];
        rightBottom = new boolean[2 * N - 1];
        right = new boolean[N];
        down = new boolean[N];

        backtracking(0);

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static void backtracking(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (rightTop[row + col] || rightBottom[(N - 1) + row - col] || right[row] || down[col]) {
                continue;
            }

            rightTop[row + col] = true;
            rightBottom[(N - 1) + row - col] = true;
            right[row] = true;
            down[col] = true;
            backtracking(row + 1);
            rightTop[row + col] = false;
            rightBottom[(N - 1) + row - col] = false;
            right[row] = false;
            down[col] = false;
        }
    }
}