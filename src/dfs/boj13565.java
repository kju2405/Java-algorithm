package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class boj13565 {
    static int[][] board;
    static boolean[][] visited;
    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visited = new boolean[R][C];

        //board초기화
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        //윗줄만 dfs
        for (int i = 0; i < C; i++) {
            dfs(0, i);
        }

        //맨 아랫줄에 visited true가 있는지 확인
//        boolean flag = false;
//        for (int i = 0; i < C; i++) {
//            if (visited[R - 1][i]) {
//                flag = true;
//            }
//        }

        //결과 출력
//        if (flag) {
//            bw.write("YES");
//        } else {
//            bw.write("NO");
//        }
        System.out.println("NO");

        bw.close();
        br.close();

    }

    private static void dfs(int x, int y) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        if (x == R - 1) {
            System.out.println("YES");
            System.exit(0);
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                continue;
            }

            if (board[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
