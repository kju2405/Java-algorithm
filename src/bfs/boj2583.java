package bfs;

import java.io.*;
import java.util.*;

public class boj2583 {
    private static int R, C;
    private static int testNum;
    private static int[][] board;
    private static int[][] dist;
    private static Queue<Pair> queue = new LinkedList<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int leftX, leftY, rightX, rightY;
    private static int resultNum = 0;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        testNum = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        dist = new int[R][C];

        initBoard();

        //직사각형에 색칠
        for (int i = 0; i < testNum; i++) {
            st = new StringTokenizer(br.readLine());
            leftY = Integer.parseInt(st.nextToken());
            leftX = R - 1 - Integer.parseInt(st.nextToken());
            rightY = Integer.parseInt(st.nextToken()) - 1;
            rightX = R - Integer.parseInt(st.nextToken());

            checkRec();
        }

        //색칠하지 않은곳 넓이 구하기
        bfs();
        list.sort(Comparator.naturalOrder());

        System.out.println(resultNum);
        list.stream().forEach(e -> System.out.print(e + " "));

    }

    private static void bfs() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1 && dist[i][j] == -1) {
                    queue.offer(new Pair(i, j));
                    dist[i][j] = 0;
                    resultNum++;
                    int area = 0;

                    while (!queue.isEmpty()) {
                        Pair cur = queue.poll();
                        area++;

                        for (int k = 0; k < dx.length; k++) {
                            int nx = cur.getX() + dx[k];
                            int ny = cur.getY() + dy[k];

                            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                                continue;
                            }

                            if (board[nx][ny] == -1 && dist[nx][ny] == -1) {
                                dist[nx][ny] = dist[cur.getX()][cur.getY()] + 1;
                                queue.offer(new Pair(nx, ny));
                            }
                        }
                    }
                    list.add(area);
                }
            }
        }
    }

    private static void checkRec() {
        for (int i = rightX; i <= leftX; i++) {
            for (int j = leftY; j <= rightY; j++) {
                board[i][j] = -2;
            }
        }
    }

    private static void initBoard() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] = -1;
                dist[i][j] = -1;
            }
        }
    }

    private static class Pair {
        int x, y;

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
