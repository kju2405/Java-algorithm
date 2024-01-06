package simulation;

import java.io.*;
import java.util.StringTokenizer;

public class boj18808 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, K;
    private static int[][] sticker;
    private static int[][] notebook;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        notebook = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int stickerRow = Integer.parseInt(st.nextToken());
            int stickerCol = Integer.parseInt(st.nextToken());
            sticker = new int[stickerRow][stickerCol];

            initSticker();

            for (int rotate = 0; rotate < 4; rotate++) {
                if (tryPlaceSticker()) {
                    break;
                }

                sticker = rotateSticker();
            }
        }

        //1의 수 계산
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j] == 1) {
                    result++;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[][] rotateSticker() {
        int tmpRow = sticker[0].length;
        int tmpCol = sticker.length;

        int[][] tmp = new int[tmpRow][tmpCol];

        for (int i = 0; i < tmpRow; i++) {
            for (int j = 0; j < tmpCol; j++) {
                tmp[i][j] = sticker[sticker.length - 1 - j][i];
            }
        }
        return tmp;
    }

    private static boolean tryPlaceSticker() {
        for (int i = 0; i < N - sticker.length + 1; i++) {
            for (int j = 0; j < M - sticker[0].length + 1; j++) {
                if (checkFit(i, j)) {
                    //notebook에 1표시 후 break;
                    markNotebook(i, j);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkFit(int r, int c) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1 && notebook[i + r][j + c] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void markNotebook(int r, int c) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1) {
                    notebook[i + r][j + c] = 1;
                }
            }
        }
    }

    private static void initSticker() throws IOException {
        for (int i = 0; i < sticker.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sticker[i].length; j++) {
                sticker[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
