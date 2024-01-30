package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class boj4963 {
    static int R, C;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            if (R == 0 && C == 0) {
                break;
            }

            //board, visited 선언
            board = new boolean[R][C];
            visited = new boolean[R][C];

            //board 초기화
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    board[i][j] = (st.nextToken().equals("1"));
                }
            }

            //dfs
            answer = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] && !visited[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            //결과 출력
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                continue;
            }

            if (board[nx][ny] && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
