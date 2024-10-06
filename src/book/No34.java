package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No34 {
    private static boolean[][] board;
    private static boolean[] visited;

    public static void main(String[] args) {
        List<int[]> graph = new ArrayList<>();
        graph.add(new int[]{1, 2});
        graph.add(new int[]{1, 3});
        graph.add(new int[]{2, 4});
        graph.add(new int[]{2, 5});
        graph.add(new int[]{3, 6});
        graph.add(new int[]{5, 6});

        int[] result = solution(graph, 1, 6);

        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(List<int[]> list, int start, int n) {
        List<Integer> result = new ArrayList<>();

        board = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        list.forEach(index->{
            int x = index[0];
            int y = index[1];

            board[x][y] = true;
            board[y][x] = true;
        });

        dfs(start, result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int start, List<Integer> result) {
        visited[start] = true;
        result.add(start);

        for (int i = 1; i < board[0].length; i++) {
            if (board[start][i] && !visited[i]) {
                dfs(i, result);
            }
        }
    }
}
