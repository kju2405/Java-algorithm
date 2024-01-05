package bfs;

import java.io.*;
import java.util.*;

public class boj2667 {

    private static char[][] board;
    private static boolean[][] visit;

    private static int size;
    private static int townNum = 0;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Queue<Pair> queue = new LinkedList<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        size = Integer.parseInt(br.readLine());

        board = new char[size][size];
        visit = new boolean[size][size];

        initBoard();

        bfs();

        resultList.sort(Comparator.naturalOrder());

        System.out.println(townNum);

        resultList.forEach(System.out::println);
    }

    private static void initBoard() throws IOException{
        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            for (int j = 0; j < size; j++) {
                board[i][j] = line.charAt(j);
            }
        }
    }

    private static void bfs() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visit[i][j] && board[i][j] == '1') {
                    queue.offer(new Pair(i, j));
                    visit[i][j] = true;
                    townNum++;

                    int area = 0;

                    while (!queue.isEmpty()) {
                        Pair cur = queue.poll();
                        area++;

                        for (int k = 0; k < dx.length; k++) {
                            int nx = cur.getX() + dx[k];
                            int ny = cur.getY() + dy[k];

                            if (nx < 0 || nx >= size || ny < 0 || ny >= size) {
                                continue;
                            }

                            if (board[nx][ny] == '1' && !visit[nx][ny]) {
                                queue.offer(new Pair(nx, ny));
                                visit[nx][ny] = true;
                            }
                        }
                    }
                        resultList.add(area);
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}