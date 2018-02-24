package roman_to_int;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("DCXXI"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1); m.put('V', 5); m.put('X', 10);
        m.put('L', 50); m.put('C', 100); m.put('D', 500); m.put('M', 1000);
        char[] a = s.toCharArray();
        int n = 0;
        for (int i = 0; i < s.length() - 1; i++)
            if (m.get(a[i]) < m.get(a[i + 1]))
                n -= m.get(a[i]);
            else n += m.get(a[i]);
        return n + m.get(a[a.length - 1]);
    }
}
