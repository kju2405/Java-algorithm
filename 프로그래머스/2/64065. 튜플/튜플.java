import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        String[] str = s.substring(1,s.length()-2).split("},");
        for(int i=0;i<str.length;i++) {
            str[i] = str[i].replace("{","");
        }
        
        
        Arrays.sort(str,(o1,o2) -> Integer.compare(o1.length(),o2.length()));
        Set<String> set = new HashSet<>();
        for(String string : str) {
            String[] splitStr = string.split(",");
            for(String number : splitStr) {
                    if(!set.contains(number)) {
                    set.add(number);
                    answer.add(Integer.parseInt(number));
                }   
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}