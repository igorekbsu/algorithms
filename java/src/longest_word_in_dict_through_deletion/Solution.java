package longest_word_in_dict_through_deletion;
import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        char[] chars = s.toCharArray();
        String r = "";
        int maxLen = Integer.MIN_VALUE;
        for (String w : d) {
            if (w.length() >= maxLen) {
                int i = 0;
                for (int j = 0; j < chars.length && i < w.length(); j++)
                    if (chars[j] == w.charAt(i))
                        i++;
                if (i == w.length()) {
                    if(w.length() == maxLen)
                        r = r.compareTo(w) > 0? w:r;
                    maxLen = Math.max(maxLen, w.length());

                }
            }
        }
        return r;
    }
}
