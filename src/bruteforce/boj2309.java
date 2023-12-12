package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //list생성
        List<Integer> dwarfHeights = new ArrayList<>();

        //9개의 숫자 입력
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(bufferedReader.readLine());
            dwarfHeights.add(height);
        }

        //9개의 숫자 전부 더하기
        int heightSum = dwarfHeights.stream()
            .mapToInt(Integer::intValue)
            .sum();

        //9개의 숫자 합에서 -100
        int cha = heightSum - 100;

        //100을 뺀 결과값과 두 수의 합이 같은 두 숫자 구하기
        int idx1 = -1, idx2 = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (dwarfHeights.get(i) + dwarfHeights.get(j) == cha) {
                    idx1 = i;
                    idx2 = j;
                    break;
                }
            }
            if (idx1 != -1) {
                break;
            }
        }

        //두 수 리스트에서 제거
        Integer value1 = dwarfHeights.get(idx1);
        Integer value2 = dwarfHeights.get(idx2);

        dwarfHeights.remove(value1);
        dwarfHeights.remove(value2);

        //나머지 배열에 넣은 후 정렬
        Collections.sort(dwarfHeights);

        //출력
        dwarfHeights.stream()
            .forEach(System.out::println);
    }
}
