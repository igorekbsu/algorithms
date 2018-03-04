package sentence_similarity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> m = new HashMap<>();
        for (String[] pair : pairs) {
            m.putIfAbsent(pair[0], new HashSet<>());
            m.get(pair[0]).add(pair[1]);
            m.putIfAbsent(pair[1], new HashSet<>());
            m.get(pair[1]).add(pair[0]);
        }
        for (int i = 0; i < words1.length; i++)
            if (!words1[i].equals(words2[i]) && !m.getOrDefault(words1[i], new HashSet<>()).contains(words2[i]))
                return false;
        return true;
    }
}
