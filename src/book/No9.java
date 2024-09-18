package book;

import java.util.*;

public class No9 {
    public static void main(String[] args) {

        int decimal = 12345;

        String ans = solution(decimal);

        System.out.println("ans = " + ans);
    }

    public static String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while (decimal != 0) {
            int mod = decimal % 2;
            decimal = decimal / 2;
            stack.push(mod);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
