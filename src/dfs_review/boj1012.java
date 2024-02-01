package dfs_review;

import java.io.*;
import java.util.StringTokenizer;

public class boj1012 {
    static boolean[][] board;
    static boolean[][] visited;
    static int row, col, baechuNum;
    static int answer;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            baechuNum = Integer.parseInt(st.nextToken());

            board = new boolean[row][col];
            visited = new boolean[row][col];

            int x, y;
            for (int j = 0; j < baechuNum; j++) {
                st = new StringTokenizer(br.readLine());
                y = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());

                board[x][y] = true;
            }

            answer = 0;
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (board[j][k] && !visited[j][k]) {
                        answer++;
                        dfs(j, k);
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.close();
        br.close();

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                continue;
            }

            if (board[nx][ny] && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
