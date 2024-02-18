import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] board;
    static int[][][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //R,C 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //배열 선언
        board = new int[R][C];
        dist = new int[2][R][C];
        queue = new LinkedList<>();

        //(1,1) 1로 초기화
        dist[0][0][0] = 1;

        //board초기화
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        //bfs
        queue.offer(new Pair(0, 0, false));
        bfs();

//        for (int i = 0; i < dist.length; i++) {
//            for (int j = 0; j < dist[i].length; j++) {
//                for (int k = 0; k < dist[i][j].length; k++) {
//                    System.out.print(dist[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        //결과 출력
        int answer = Math.max(dist[0][R - 1][C - 1], dist[1][R - 1][C - 1]);

        if (answer == 0) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(answer));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (cur.x == R - 1 && cur.y == C - 1) {
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    if (cur.crashed) {
                        if (dist[1][nx][ny] == 0) {
                            dist[1][nx][ny] = dist[1][cur.x][cur.y] + 1;
                            queue.offer(new Pair(nx, ny, true));
                        }
                    } else {
                        if (dist[0][nx][ny] == 0) {
                            dist[0][nx][ny] = dist[0][cur.x][cur.y] + 1;
                            queue.offer(new Pair(nx, ny, false));
                        }
                    }
                } else {
                    if (!cur.crashed) {
                        if (dist[1][nx][ny] == 0) {
                            dist[1][nx][ny] = dist[0][cur.x][cur.y] + 1;
                            queue.offer(new Pair(nx, ny, true));
                        }
                    }
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;
        boolean crashed;

        Pair(int x, int y, boolean crashed) {
            this.x = x;
            this.y = y;
            this.crashed = crashed;
        }
    }
}