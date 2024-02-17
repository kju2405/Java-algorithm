package dfs;

import java.io.*;
import java.util.*;

public class boj9466 {
    static int stuNum;
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            //학생 수 입력
            stuNum = Integer.parseInt(br.readLine());

            //배열 선언
            students = new int[stuNum + 1];
            visited = new boolean[stuNum + 1];
            finished = new boolean[stuNum + 1];
            answer = stuNum;

            //배열 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= stuNum; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            //dfs
            for (int i = 1; i <= stuNum; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            //결과 출력
            bw.write(String.valueOf(answer));
            bw.newLine();

        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true;

        int next = students[idx];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                for (int i = next; i != idx; i = students[i]) {
                    answer--;
                }
                answer--;
            }
        }
        finished[idx] = true;
    }
}