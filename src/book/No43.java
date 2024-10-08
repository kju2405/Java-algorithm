package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No43 {
    private static List<int[]> answer = new ArrayList<>();
    private static int Num;

    public static void main(String[] args) {
        Num = 5;

        List<int[]> result = solution(Num);

        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static List<int[]> solution(int n) {

        backtracking(0, new ArrayList<>(), 1);
        return answer;
    }

    private static void backtracking(int sum, ArrayList<Integer> list, int start) {
        if (sum == 10) {
            int[] array = list.stream().mapToInt(Integer::intValue).toArray();
            answer.add(array);
            return;
        }

        for (int i = start; i <= Num; i++) {
            if (sum + i > 10) {
                continue;
            }

            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(i);
            backtracking(sum + i, newList, i + 1);
        }
    }
}
