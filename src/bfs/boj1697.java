package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj1697 {
    private static int[] board = new int[100001];
    private static Queue<Integer> queue = new LinkedList<>();
    private static int[] dx = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nkArray = br.readLine().split(" ");
        int subinLocation = Integer.parseInt(nkArray[0]);
        int brotherLocation = Integer.parseInt(nkArray[1]);

        //board초기화
        Arrays.fill(board, -1);

        //수빈이 위치 초기화
        board[subinLocation] = 0;
        queue.offer(subinLocation);

        //동생을 찾는 시간 계산
        int secound = calculateTime(subinLocation, brotherLocation);

        //시간출력
        System.out.println(secound);
    }

    private static int calculateTime(int subinLocation, int brotherLocation) {
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int idx = 0; idx < 3; idx++) {
                int nx;
                if (idx < 2) {
                    nx = cur + dx[idx];
                } else {
                    nx = cur * dx[idx];
                }

                if (nx < 0 || nx >= board.length || board[nx] != -1) {
                    continue;
                }
                if (nx == brotherLocation) {
                    return board[cur] + 1;
                }

                board[nx] = board[cur] + 1;
                queue.offer(nx);
            }
        }
        return 0;
    }
}
