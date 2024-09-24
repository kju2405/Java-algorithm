package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No30 {
    public static void main(String[] args) {
//        int k = 3;
//        int[][] operations = {
//            {0, 0, 1},
//            {0, 1, 2},
//            {1, 1, 2}
//        };

        int k = 4;
        int[][] operations = {
            {0, 0, 1},
            {1, 1, 2},
            {0, 1, 2},
            {1, 0, 2}
        };

        boolean[] result = solution(k, operations);

        System.out.println(Arrays.toString(result));
    }

    private static boolean[] solution(int k, int[][] operations) {
        int[] arr = new int[k];
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < operations.length; i++) {
            int[] op = operations[i];
            int num = op[0];
            if (num == 0) {
                //union
                int root1 = find(op[1], arr);
                int root2 = find(op[2], arr);
                arr[root2] = root1;
            } else {
                //find
                int root1 = find(op[1], arr);
                int root2 = find(op[2], arr);
                result.add(root1 == root2);
            }
        }

        boolean[] resultArr = new boolean[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }

    private static int find(int num, int[] arr) {
        if (num == arr[num]) {
            return num;
        }

        return find(arr[num], arr);
    }
}
