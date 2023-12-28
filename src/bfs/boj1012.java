package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1012 {
    private static int[][] board;
    private static boolean[][] visit;
    private static Queue<Pair> queue = new LinkedList<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int baechuNum = Integer.parseInt(st.nextToken());

            //배열 초기화
            board = new int[row][col];
            visit = new boolean[row][col];

            //배추 위치 초기화
            initBaechu(baechuNum);

            //흰 지렁이 갯수 계산
            int result = calculateResult();

            //결과 입력
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initBaechu(int baechuNum) throws IOException{
        StringTokenizer st;
        for (int i = 0; i < baechuNum; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 1;
        }
    }

    private static int calculateResult() {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 || visit[i][j]) {
                    continue;

                }

                queue.offer(new Pair(i, j));
                visit[i][j] = true;
                result++;

                while (!queue.isEmpty()) {
                    Pair cur = queue.poll();

                    for (int idx = 0; idx < 4; idx++) {
                        int nx = cur.getX() + dx[idx];
                        int ny = cur.getY() + dy[idx];
                        if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                            continue;
                        }

                        if (board[nx][ny] == 0 || visit[nx][ny]) {
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

    private static class Pair {
        private int x;
        private int y;

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
