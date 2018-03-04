package longest_word_in_dict;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> s = new HashSet<>();
        String r = "";
        for (String w : words)
            if (w.length() == 1 || s.contains(w.substring(0, w.length() - 1))) {
                r = w.length() > r.length() ? w : r;
                s.add(w);
            }
        return r;
    }
}
