package book;

import java.util.Arrays;

public class No51 {
    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        int[] result = solution(arr1, arr2);

        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] arr1, int[] arr2) {
        int arr1Size = arr1.length;
        int arr2Size = arr2.length;
        int[] result = new int[arr1Size + arr2Size];

        int idx1 = 0;
        int idx2 = 0;
        int resultIdx = 0;

        while (idx1 != arr1Size && idx2 != arr2Size) {
            result[resultIdx++] = arr1[idx1] < arr2[idx2] ? arr1[idx1++] : arr2[idx2++];
        }

        if (idx1 < arr1Size) {
            result[resultIdx++] = arr1[idx1++];
        } else {
            result[resultIdx++] = arr2[idx2++];
        }

        return result;
    }
}
