package roman_to_int;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1); m.put('V', 5); m.put('X', 10); m.put('L', 50); m.put('C', 100); m.put('D', 500); m.put('M', 1000);
        char[] a = s.toCharArray();
        int r = m.get(a[0]);
        for (int i = 1; i < a.length; i++)
            if (m.get(a[i]) > m.get(a[i - 1]))
                r -= m.get(a[i - 1]);
            else r += m.get(a[i]);
        return r;
    }
}
