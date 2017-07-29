package word_pattern;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (str == null || pattern == null) return false;
        Map<Character, String> map = new HashMap<>();
        String[] split = str.split(" ");
        if (split.length != pattern.length()) return false;
        for (int i = 0; i < split.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(split[i]))
                    return false;
            } else {
                if (map.containsValue(split[i]))
                    return false;
                map.put(c, split[i]);
            }
        }
        return true;
    }
}
