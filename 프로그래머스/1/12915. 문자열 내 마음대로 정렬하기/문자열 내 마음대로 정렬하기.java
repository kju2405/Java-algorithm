import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        System.out.println(n);
        Arrays.sort(strings, (c1,c2) -> c1.charAt(n) == c2.charAt(n) ? 
                    c1.compareTo(c2) : Character.compare(c1.charAt(n),c2.charAt(n)));
        return strings;
    }
}