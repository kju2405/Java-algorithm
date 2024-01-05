package simulation;

import java.io.*;
import java.util.*;

public class boj15683 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int row, col;
    private static int[][] board1;
    private static int[][] board2;
    private static int mn = 0;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static List<Pair> cctvList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board1 = new int[row][col];
        board2 = new int[row][col];

        initBoard();

        for (int i = 0; i < (1 << (2 * cctvList.size())); i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    board2[j][k] = board1[j][k];
                }
            }
            int brute = i;
            for (int j = 0; j < cctvList.size(); j++) {
                int dir = brute % 4;
                Pair cur = cctvList.get(j);
                if (board1[cur.getX()][cur.getY()] == 1) {
                    upd(cur.getX(), cur.getY(), dir);
                } else if (board1[cur.getX()][cur.getY()] == 2) {
                    upd(cur.getX(), cur.getY(), dir);
                    upd(cur.getX(), cur.getY(), dir + 2);
                } else if (board1[cur.getX()][cur.getY()] == 3) {
                    upd(cur.getX(), cur.getY(), dir);
                    upd(cur.getX(), cur.getY(), dir + 1);
                } else if (board1[cur.getX()][cur.getY()] == 4) {
                    upd(cur.getX(), cur.getY(), dir);
                    upd(cur.getX(), cur.getY(), dir + 1);
                    upd(cur.getX(), cur.getY(), dir + 2);
                } else {
                    upd(cur.getX(), cur.getY(), dir);
                    upd(cur.getX(), cur.getY(), dir + 1);
                    upd(cur.getX(), cur.getY(), dir + 2);
                    upd(cur.getX(), cur.getY(), dir + 3);
                }
                brute /= 4;
            }

            int val = 0;
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (board2[r][c] == 0) {
                        val++;
                    }
                }
            }

            mn = Math.min(val, mn);
        }

        bw.write(String.valueOf(mn));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void upd(int x, int y, int dir) {
        dir = dir % 4;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= row || ny < 0 || ny >= col || board2[nx][ny] == 6) {
                return;
            }

            if (board2[nx][ny] != 0) {
                x = nx;
                y = ny;
                continue;
            }

            board2[nx][ny] = 7;
            x = nx;
            y = ny;
        }
    }

    private static void initBoard() throws IOException {
        for (int i = 0; i < row; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
                if (board1[i][j] != 0 && board1[i][j] != 6) {
                    cctvList.add(new Pair(i, j));
                }
                if (board1[i][j] == 0) {
                    mn++;
                }
            }
        }
    }

}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}