package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1926 {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int picNum = 0;
    private static int picMaxSize = 0;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        //행, 열 입력
        String inputRowCol = bufferedReader.readLine();
        String[] rowColArray = inputRowCol.split(" ");

        int row = Integer.parseInt(rowColArray[0]);
        int col = Integer.parseInt(rowColArray[1]);

        //입력받은 크기의 배열 생성
        int[][] board = new int[row][col];
        boolean[][] visit = new boolean[row][col];

        //배열 채우기
        fillBoard(board);

        //그림 개수와 그림의 최대 크기 구하기 - BFS
        calculatePicNumAndMaxSize(board, visit);

        //정답 출력
        System.out.println(picNum);
        System.out.println(picMaxSize);
    }

    private static void calculatePicNumAndMaxSize(int[][] board, boolean[][] visit) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 || visit[i][j]) {
                    continue;
                }

                picNum++;
                queue.offer(new Pair(i, j));
                visit[i][j] = true;

                int picSize = 0;
                while (!queue.isEmpty()) {
                    Pair cur = queue.poll();
                    picSize++;

                    for (int k = 0; k < 4; k++) {
                        int checkX = cur.getX() + dx[k];
                        int checkY = cur.getY() + dy[k];

                        //board를 벗어난 인덱스라면 continue
                        if (checkX < 0 || checkX >= board.length || checkY < 0 || checkY >= board[i].length) {
                            continue;
                        }

                        //1이고 방문하지 않았다면 queue에 넣기
                        if (board[checkX][checkY] == 1 && !visit[checkX][checkY]) {
                            queue.offer(new Pair(checkX, checkY));
                            visit[checkX][checkY] = true;
                        }
                    }
                }
                picMaxSize = Math.max(picMaxSize, picSize);
            }
        }
    }

    private static void fillBoard(int[][] board) throws IOException {
        for (int i = 0; i < board.length; i++) {
            String line = bufferedReader.readLine();
            String[] lineArray = line.split(" ");
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(lineArray[j]);
            }
        }
    }

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}


