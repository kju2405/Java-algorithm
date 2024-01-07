package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCnt = Integer.parseInt(br.readLine());

        Pair[] arr = new Pair[testCnt];

        StringTokenizer st;
        for (int i = 0; i < testCnt; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //y를 기준으로 정렬
        Arrays.sort(arr, Comparator.comparingInt(Pair::getY));

        //x를 기준으로 정렬
        Arrays.sort(arr, Comparator.comparingInt(Pair::getX));

        //출력
        for (int i = 0; i < testCnt; i++) {
            bw.write(arr[i].getX() + " " + arr[i].getY() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Pair{
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
