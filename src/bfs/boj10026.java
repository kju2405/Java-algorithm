package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class boj10026 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static char[][] board;
    private static boolean[][] visit;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n;

    private static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //한 변의 크기 입력
        n = Integer.parseInt(br.readLine());

        //배열 크기 선언
        board = new char[n][n];
        visit = new boolean[n][n];

        //배열 초기확
        initBoard();

        //일반인 결과 계산
        int normalResult = calculateResult();

        //visit 초기화
        initVisit();

        //board r->g
        changeRedToGreen();

        //적록색약 결과 계산
        int redGreenResult = calculateResult();

        //출력
        bw.write(normalResult + " " + redGreenResult);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void initBoard() throws IOException {
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }
    }

    private static int calculateResult() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) {
                    continue;
                }
                queue.offer(new Pair(i, j));
                result++;
                char ch = board[i][j];

                while (!queue.isEmpty()) {
                    Pair cur = queue.poll();
                    for (int idx = 0; idx < 4; idx++) {
                        int nx = cur.getX() + dx[idx];
                        int ny = cur.getY() + dy[idx];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }
                        if (visit[nx][ny] || board[nx][ny] != ch) {
                            continue;
                        }

                        queue.offer(new Pair(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        return result;
    }

    private static void initVisit() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = false;
            }
        }
    }

    private static void changeRedToGreen() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    board[i][j] = 'G';
                }
            }
        }
    }


    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int getX() {
            return x;
        }

        private int getY() {
            return y;
        }
    }
}
