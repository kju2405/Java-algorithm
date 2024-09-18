package book;

import java.util.*;

public class No15 {
    public static void main(String[] args) {
        int N = 5;
        int K = 2;
        int result = solution(N, K);

        System.out.println("result = " + result);
    }

    private static int solution(int N, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        //queue 초기화
        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }

        while (queue.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.addLast(queue.pollFirst());
            }
            queue.pollFirst();
        }

        return queue.pollFirst();
    }
}
