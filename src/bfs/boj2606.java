package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2606 {
    private static boolean[][] board;
    private static boolean[] visit;
    private static Queue<Integer> queue = new LinkedList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        //컴퓨터 수 입력
        int comCnt = Integer.parseInt(br.readLine());

        //네트워크 연결 컴퓨터 쌍의 수 입력
        int pairCnt = Integer.parseInt(br.readLine());

        //배열 선언
        board = new boolean[comCnt + 1][comCnt + 1];
        visit = new boolean[comCnt + 1];

        //board 초기화
        initBoard(pairCnt);

        int result = calculateResult(comCnt);

        System.out.println(result);
    }

    private static void initBoard(int pairCnt) throws IOException {
        for (int i = 0; i < pairCnt; i++) {
            String[] rowColArray = br.readLine().split(" ");
            int row = Integer.parseInt(rowColArray[0]);
            int col = Integer.parseInt(rowColArray[1]);

            board[row][col] = board[col][row] = true;
        }
    }

    private static int calculateResult(int comCnt) {
        queue.offer(1);
        visit[1] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            cnt++;
            for (int i = 1; i <= comCnt; i++) {
                if (board[cur][i] && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
        return cnt - 1;
    }
}
