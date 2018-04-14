package word_pattern;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String p, String str) {
        String[] words = str.split(" ");
        if (p.length() != words.length) return false;
        Map<String, Character> m = new HashMap<>();
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            char c = p.charAt(i);
            if (used.add(c)) {
                if (m.put(words[i], c) != null)
                    return false;
            } else if (m.getOrDefault(words[i], ' ') != c)
                return false;
        }
        return true;
    }
}
