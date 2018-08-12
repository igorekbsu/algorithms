package substring_with_concatenation_of_all_words;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> m = new HashMap<>();
        for (final String word : words)
            m.put(word, m.getOrDefault(word, 0) + 1);
        List<Integer> r = new LinkedList<>();
        if (words.length == 0) return r;
        int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if (m.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > m.getOrDefault(word, 0))
                        break;
                } else break;
                j++;
            }
            if (j == num)
                r.add(i);
        }
        return r;
    }
}
