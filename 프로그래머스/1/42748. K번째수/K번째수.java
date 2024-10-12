import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for(int[] arr : commands) {
            int i=arr[0];
            int j=arr[1];
            int k=arr[2];
            int[] copyArr = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(copyArr);
            answer.add(copyArr[k-1]);    
        }
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}