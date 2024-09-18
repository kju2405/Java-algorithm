package book;

import java.util.Arrays;
import java.util.Collections;

public class No2 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 1, 3, 4};
        int[] result = solution(arr);

        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] arr) {
        Integer[] array = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());

        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }
}
