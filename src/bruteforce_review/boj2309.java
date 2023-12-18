package bruteforce_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj2309 {
    private static final List<Integer> talls = new ArrayList<>();
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private static final int totalTall = 100;

    public static void main(String[] args) throws IOException {


        //키 입력받아 리스트에 저장
        storeTalls();

        //전체 합 - 100 구하기
        int tallSum = talls.stream().mapToInt(Integer::intValue).sum();
        int cha = tallSum - totalTall;

        //두 요소의 합이 (전체 합 - 100)과 같은 요소 찾기
        int tall1 = -1;
        int tall2 = -1;

        for (int i = 0; i < talls.size() - 1; i++) {
            for (int j = i + 1; j < talls.size(); j++) {
                if (talls.get(i) + talls.get(j) == cha) {
                    tall1 = talls.get(i);
                    tall2 = talls.get(j);
                    break;
                }
            }
            if (tall1 != -1) {
                break;
            }
        }

        //위에서 찾은 두 요소 제거
        removeTallByTall(tall1, tall2);

        //정렬
        Collections.sort(talls);

        //출력
        printTalls();
    }

    private static void printTalls() {
        for (int i = 0; i < talls.size(); i++) {
            System.out.println(talls.get(i));
        }
    }

    private static void removeTallByTall(int tall1, int tall2) {
        for (int i = 0; i < talls.size(); i++) {
            if (talls.get(i) == tall1 || talls.get(i) == tall2) {
                talls.remove(i);
                i--;
            }
        }
    }

    private static void storeTalls() throws IOException {
        for (int i = 0; i < 9; i++) {
            int tall = Integer.parseInt(bufferedReader.readLine());
            talls.add(tall);
        }
    }
}
