import java.util.*;

class Solution {
    public long solution(long n) {
        String stringN=String.valueOf(n);
        int len = stringN.length();
        Integer[] nums=new Integer[len];
        
        int idx=0;
        while(n>0) {
            nums[idx++]=(int)(n%10);
            n/=10;
        }
        
        Arrays.sort(nums,(o1,o2) -> Integer.compare(o2,o1));
        
        long answer=0l;
        for(int i=0;i<len;i++) {
            answer+=nums[i];
            answer*=10;
        }
        
        answer/=10;
        
        return answer;
    }
}