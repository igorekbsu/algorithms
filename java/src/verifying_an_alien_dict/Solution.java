package verifying_an_alien_dict;
import java.util.stream.IntStream;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        for (int i = 0; i < ord.length; i++)
            ord[order.charAt(i) - 'a'] = i;
        return IntStream.range(1, words.length).allMatch(i -> inOrder(words[i - 1], words[i], ord));

    }

    boolean inOrder(String w1, String w2, int[] ord) {
        for (int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
            int diff = ord[w1.charAt(i) - 'a'] - ord[w2.charAt(i) - 'a'];
            if (diff > 0)
                return false;
            else if (diff < 0)  
                return true;
        }
        return w1.length() <= w2.length();
    }
}
