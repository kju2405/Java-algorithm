package dfs_review;

import java.io.*;
import java.util.StringTokenizer;

public class boj1388 {
    static boolean[][] board;
    static boolean[][] visited;
    static int row, col;
    static int answer;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new boolean[row][col];
        visited = new boolean[row][col];

        //graph초기화, | : false, - :true
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                char ch = line.charAt(j);
                if (ch == '-') {
                    board[i][j] = true;
                }
            }
        }

        //dfs
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    answer++;
                    dfs(i, j);
                }
            }
        }

        //값 출력
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                continue;
            }

            if (board[x][y] && board[nx][ny] && !visited[nx][ny] && i == 1) {
                dfs(nx, ny);
            }

            if (!board[x][y] && !board[nx][ny] && !visited[nx][ny] && i == 0) {
                dfs(nx, ny);
            }
        }
    }
}
