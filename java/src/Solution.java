public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().wordsTyping(new String[]{"me", "me"}, 2, 2));
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int wc = 0;
        for (int r = 0; r < rows; r++) {
            int start = wc % sentence.length;
            for (int i = start, len = 0; len < cols; i = (i + 1) % sentence.length, wc++) {
                if (len + sentence[i].length() > cols) break;
                len += sentence[i].length() + 1;
            }
        }
        return wc / sentence.length;
    }
}
