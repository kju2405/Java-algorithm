package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj4179 {
    private static char[][] board;
    private static int[][] fireDist;
    private static int[][] jihoonDist;
    private static Queue<Pair> fireQueue = new LinkedList<>();
    private static Queue<Pair> jihoonQueue = new LinkedList<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        //R, C 입력
        String[] rcArray = br.readLine().split(" ");
        int r = Integer.parseInt(rcArray[0]);
        int c = Integer.parseInt(rcArray[1]);

        //배열 선언
        board = new char[r][c];
        fireDist = new int[r][c];
        jihoonDist = new int[r][c];

        //dist 초기화
        initDist();

        //Board 채우기
        fillArray();

        //불 bfs
        fireBfs();

        //지훈이 bfs
        jihoonBfs();
    }

    private static void initDist() {
        for (int i = 0; i < fireDist.length; i++) {
            for (int j = 0; j < fireDist[i].length; j++) {
                fireDist[i][j] = -1;
                jihoonDist[i][j] = -1;
            }
        }
    }

    private static void fillArray() throws IOException {
        for (int i = 0; i < board.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'J') {
                    jihoonDist[i][j] = 0;
                    jihoonQueue.offer(new Pair(i, j));
                }

                if (board[i][j] == 'F') {
                    fireDist[i][j] = 0;
                    fireQueue.offer(new Pair(i, j));
                }
            }
        }
    }

    private static void fireBfs() {
        while (!fireQueue.isEmpty()) {
            Pair cur = fireQueue.poll();

            for (int idx = 0; idx < 4; idx++) {
                int nx = cur.getX() + dx[idx];
                int ny = cur.getY() + dy[idx];

                if (nx < 0 || nx >= fireDist.length || ny < 0 || ny >= fireDist[0].length) {
                    continue;
                }
                if (fireDist[nx][ny] != -1 || board[nx][ny] == '#') {
                    continue;
                }

                fireDist[nx][ny] = fireDist[cur.getX()][cur.getY()] + 1;
                fireQueue.offer(new Pair(nx, ny));
            }
        }
    }

    private static void jihoonBfs() {
        while (!jihoonQueue.isEmpty()) {
            Pair cur = jihoonQueue.poll();
            for (int idx = 0; idx < 4; idx++) {
                int nx = cur.getX() + dx[idx];
                int ny = cur.getY() + dy[idx];

                if (nx < 0 || nx >= jihoonDist.length || ny < 0 || ny >= jihoonDist[0].length) {
                    System.out.println(jihoonDist[cur.getX()][cur.getY()] + 1);
                    return;
                }
                if (jihoonDist[nx][ny] != -1 || board[nx][ny] == '#') {
                    continue;
                }
                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jihoonDist[cur.getX()][cur.getY()] + 1) {
                    continue;
                }

                jihoonDist[nx][ny] = jihoonDist[cur.getX()][cur.getY()] + 1;
                jihoonQueue.offer(new Pair(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
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
