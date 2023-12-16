package bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class boj9095 {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        list.addAll(List.of(0, 1, 2, 4));

        //11꺄지 list채우기
        fillList();

        //testCase 갯수 입력
        int testCaseNum = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCaseNum; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());

            bufferedWriter.write(list.get(num) + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void fillList() {
        for (int i = 4; i < 11; i++) {
            list.add(list.get(i - 3) + list.get(i - 2) + list.get(i - 1));
        }
    }
}
