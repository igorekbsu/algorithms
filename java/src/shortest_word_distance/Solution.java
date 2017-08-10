package shortest_word_distance;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestDistance(new String[]{"a", "b"}, "a", "b"));
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        int r = Integer.MAX_VALUE, w1i = Integer.MAX_VALUE, w2i = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                w1i = i;
                r = Math.min(r, Math.abs(w2i - w1i));
            }
            if (words[i].equals(word2)) {
                w2i = i;
                r = Math.min(r, Math.abs(w2i - w1i));
            }
        }
        return r;
    }
}
