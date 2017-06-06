package word_break;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        Set<String> words = new HashSet<>(dict);
        boolean[] m = new boolean[s.length() + 1];
        m[0] = true;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j < i; j++) {
                if (m[j] && words.contains(s.substring(j, i))) {
                    m[i] = true;
                    break;
                }
            }
        return m[s.length()];
    }
}