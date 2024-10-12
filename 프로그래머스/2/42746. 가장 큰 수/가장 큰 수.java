import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> stringNumbers=new ArrayList<>();
        for(int num : numbers) {
            stringNumbers.add(String.valueOf(num));
        }
        
        stringNumbers.sort((o1,o2) -> {
            int a = Integer.parseInt(o1+o2);
            int b = Integer.parseInt(o2+o1);
            return Integer.compare(b,a);
        });
        
        StringBuilder sb = new StringBuilder();
        stringNumbers.forEach(o1 -> sb.append(o1));
        
        return sb.toString().charAt(0)=='0' ? "0" : sb.toString();
    }
}