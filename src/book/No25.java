package book;

import java.util.Arrays;

public class No25 {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};

        String[] result = solution(nodes);

        System.out.println(Arrays.toString(result));
    }

    private static String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preOrder(nodes, 0).trim();
        result[1] = inOrder(nodes, 0).trim();
        result[2] = postOrder(nodes, 0).trim();

        return result;
    }

    private static String preOrder(int[] nodes, int idx) {

        if (idx >= nodes.length) {
            return "";
        }

        return nodes[idx] + " " + preOrder(nodes, 2 * idx + 1) + preOrder(nodes, 2 * idx + 2);
    }

    private static String inOrder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return inOrder(nodes, 2 * idx + 1) + nodes[idx] + " " + inOrder(nodes, 2 * idx + 2);
    }

    private static String postOrder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return postOrder(nodes, idx * 2 + 1) + postOrder(nodes, idx * 2 + 2) + nodes[idx] + " ";
    }
}
