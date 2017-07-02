package strobogrammatic;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> m = new HashMap<>();
        m.put('6', '9'); m.put('9', '6'); m.put('1', '1'); m.put('8', '8'); m.put('0', '0');
        for (int left = 0, right = num.length() - 1; left <= right; left++, right--) {
            char c = num.charAt(left);
            if (!m.containsKey(c)) return false;
            if (m.get(c) != num.charAt(right)) return false;
        }
        return true;
    }
}
