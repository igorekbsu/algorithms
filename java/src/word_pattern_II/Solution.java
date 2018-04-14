package word_pattern_II;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if (str.length() == 0 && pattern.length() == 0) return true;
        if (str.length() == 0 || pattern.length() == 0) return false;
        return dfs(pattern, str, new HashMap<>(), new HashSet<>());
    }

    private boolean dfs(String pattern, String str, Map<Character, String> map, Set<String> matched) {
        if (pattern.length() == 0 && str.length() == 0) return true;
        if (pattern.length() == 0 || str.length() == 0) return false;
        String mapString = map.get(pattern.charAt(0));
        if (mapString != null) {
            if (str.startsWith(mapString))
                return dfs(pattern.substring(1), str.substring(mapString.length()), map, matched);
            return false;
        }
        for (int i = 0; i <= str.length() - pattern.length(); i++) {
            String current = str.substring(0, i + 1);
            if (matched.add(current)) {
                map.put(pattern.charAt(0), current);
                if (dfs(pattern.substring(1), str.substring(i + 1), map, matched)) return true;
                map.remove(pattern.charAt(0));
                matched.remove(current);
            }
        }
        return false;
    }
}
