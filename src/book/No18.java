package book;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No18 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 8};
        int target = 10;
        boolean result = solution(arr, target);

        System.out.println("result = " + result);
    }

    private static boolean solution(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
