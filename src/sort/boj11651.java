package sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11651 {
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

        Arrays.sort(arr,(p1,p2)->{
            return p1.y != p2.y ? p1.y - p2.y : p1.x - p2.x;
        });

        for (int i = 0; i < testCnt; i++) {
            bw.write(arr[i].x + " " + arr[i].y + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}