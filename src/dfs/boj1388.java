package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class boj1388 {
    static boolean[][] board;
    static boolean[][] visited;
    static int R, C;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //board, visited 선언
        board = new boolean[R][C];
        visited = new boolean[R][C];

        //board초기화
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j) == '-';
            }
        }

        //dfs
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j]) {
                    answer++;
                    dfs(i, j);
                }
            }
        }

        //결과출력
        bw.write(String.valueOf(answer));
        bw.newLine();

        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if (board[x][y]) {  //'-'일 경우
            int nx = x;
            int ny = y + 1;

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                return;
            }

            if (board[nx][ny] && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        } else {
            int nx = x + 1;
            int ny = y;

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                return;
            }

            if (!board[nx][ny] && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
