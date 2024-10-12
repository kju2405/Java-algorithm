public class Main {
    public static void main(String[] args) {

        String s = "hello";

        String result = solution(s);

        System.out.println("result = " + result);
    }

    private static String solution(String s) {
        int size = 'z' - 'a' + 1;
        int[] alphabet = new int[size];
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            int index = ch - 'a';
            alphabet[index]++;
        }

        StringBuffer sb = new StringBuffer();
        for (int idx = 0; idx < alphabet.length; idx++) {
            int num = alphabet[idx];
            while (num-- > 0) {
                sb.append((char) ('a' + idx));
            }
        }

        return sb.toString();
    }
}